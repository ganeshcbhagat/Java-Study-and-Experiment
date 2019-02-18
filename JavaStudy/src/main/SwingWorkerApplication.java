package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class SwingWorkerApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel messageLabel;
	private JProgressBar progressBar;
	private JTextArea progressTextArea;
	private JButton stopButton;
	private SearchForWordWorker worker;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel bottomPanel;
	private JButton startButton;
	
	// The worker parameters
	private Informable informable;
	private String[] stringLine = { "this is a simple", "paragraph that is meant", "to be nice and easy",
									"to type which is why", "there will be mommas no periods", "or any capital letters so i guess this",
									"means that it cannot", "really be considered", "a paragraph but just", "a series of run on sentences",
									"this should help you", "get faster at typing as", "im trying not to use too", "many difficult words",
									"in it although i think that", "i might start making", "it hard by including",
									"some more difficult letters"
								};
	
	private PropertyChangeListener listener;
	private JLabel wordFoundInLbl;
	private JTextField searchTextField;
	private JLabel searchLbl;
	private JList listOfLines;
	private JPanel leftPanel;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SwingWorkerApplication app = new SwingWorkerApplication();
				app.pack();
				app.setVisible(true);
			}
		});
	}

	public SwingWorkerApplication() {
		setMinimumSize(new Dimension(600, 750));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SwingWorker Example");
		initComponents();
	}

	private void initComponents() {
		
		setLocationRelativeTo(null);
		topPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) topPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(topPanel, BorderLayout.NORTH);

		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				wordFoundInLbl.setText("");
				progressTextArea.setText("");
				progressBar.setVisible(true);
				worker=null;
				initSwingWorker(searchTextField.getText(), stringLine, informable, listener);
				
				// Start the worker. Note that control is returned immediately
				worker.execute();
			}
		});
		
		searchLbl = new JLabel("Search");
		topPanel.add(searchLbl);
		
		searchTextField = new JTextField();
		searchTextField.setText("this");
		topPanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		topPanel.add(startButton);

		// The cancel button
		stopButton = new JButton("Stop");
		stopButton.setEnabled(false);
		topPanel.add(stopButton);
		
		wordFoundInLbl = new JLabel("");
		topPanel.add(wordFoundInLbl);
		
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Cancel the worker and wake it up should it be sleeping
				if(worker!=null) {
					worker.cancel(true);
				}
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
			}
		});

		centerPanel = new JPanel();
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(0, 0));

		progressTextArea = new JTextArea(5, 30);
		progressTextArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		progressTextArea.setBorder(new EmptyBorder(4, 4, 0, 0));
		progressTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(progressTextArea);
		centerPanel.add(scrollPane);
		
		leftPanel = new JPanel();
		getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BorderLayout(0, 0));
		
		listOfLines = new JList(stringLine);
		leftPanel.add(listOfLines, BorderLayout.WEST);
		listOfLines.setBorder(new EmptyBorder(4, 4, 4, 4));

		bottomPanel = new JPanel();
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));

		progressBar = new JProgressBar();
		bottomPanel.add(progressBar, BorderLayout.NORTH);
		progressBar.setStringPainted(true);

		// The UI components
		messageLabel = new JLabel("");
		bottomPanel.add(messageLabel, BorderLayout.SOUTH);

		// The interface will update the text of the UI components
		informable = new Informable() {
						@Override
						public void messageChanged(String message) {
							String [] lineX= message.split(":");
							int xIndex = 0;
							try{
								xIndex=new Integer(lineX[1]);
								messageLabel.setText(stringLine[xIndex]);
								progressTextArea.append(message+ " "+ stringLine[xIndex] + "\n");
								listOfLines.setSelectedIndex(xIndex);
								listOfLines.requestFocus();
								
							} catch (Exception e) {}
							
						}
					};

		// A property listener used to update the progress bar
		listener = new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				if ("progress".equals(event.getPropertyName())) {
					progressBar.setValue((Integer) event.getNewValue());
				}
				
				if (SearchForWordWorker.MY_PROPERTY_WORD_FOUND.equals(event.getPropertyName())) {
					wordFoundInLbl.setText((String)event.getNewValue());
				}
				
				if (SearchForWordWorker.MY_PROPERTY_WORD_RESULT.equals(event.getPropertyName())) {
					messageLabel.setText("Found: " + (String)event.getNewValue());
					progressTextArea.append("Done\n");
					progressTextArea.append("Matches Found: " + (String)event.getNewValue() + "\n");
					progressBar.setVisible(false);
					startButton.setEnabled(true);
					stopButton.setEnabled(false);
				}				
			}
		};
	}

	private void initSwingWorker(String word, String[] stringLine, Informable informable, PropertyChangeListener listener ) {
		if(worker==null) {
			worker = new SearchForWordWorker(word, stringLine, informable);
			worker.removePropertyChangeListener(listener);
			worker.addPropertyChangeListener(listener);
		}
	}
	
	private interface Informable {
		void messageChanged(String message);
	}

	private class SearchForWordWorker extends SwingWorker<Integer, String> {

		private final String word;
		private final String[] stringLine;
		private final Informable informable;

		public static final String MY_PROPERTY_WORD_RESULT = "MY_PROPERTY_RESULT";
		public static final String MY_PROPERTY_WORD_FOUND = "MY_PROPERTY_WORD_FOUND";
		
		public SearchForWordWorker(String word, String[] stringLine, Informable informable) {
			this.word = word;
			this.stringLine = stringLine;
			this.informable = informable;
		}

		@Override
		protected Integer doInBackground() throws Exception {
			int matches = 0;
			int size = stringLine.length;
			
			for (int i = 0;  i < size; i++) {
				
				if (isCancelled()) {
					break;
				}
				
				// Update the status: so the intermediate part sends to process method
				publish("Searching in :" + i);
				
				Thread.sleep(500);
				// Do the search stuff
				if (stringLine[i].contains(word)) {
					// Here you increment the variable matches
					matches = matches + 1;
					firePropertyChange(MY_PROPERTY_WORD_FOUND, "", "("+matches+ ") ["+stringLine[i]+"]");
				}

				// update the progress progress bar will update its value in PropertyChangeChangeListener by seeking 'progress' property
				setProgress((i + 1) * 100 / size);
			}
			
			return matches;
		}

		@Override
		protected void process(List<String> chunks) {
			for (String message : chunks) {
				informable.messageChanged(message);
			}
		}
		
		//done method will call when the doInBackground method completed or cancel method get called
		@Override
		protected void done() {
			try {
				int matches = get();
				firePropertyChange(MY_PROPERTY_WORD_RESULT, "", "Found: " + matches);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(SwingWorkerApplication.this, "Error "+e.getMessage(), "Search", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
