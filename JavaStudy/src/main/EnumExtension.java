package main;

import java.io.File;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class EnumExtension {

	public static void main(String[] args) {
		
		BasicMonoFont.addNewFont(ExMonoFont.Andale);
		BasicMonoFont.addNewFont(ExMonoFont.Lucida);
		BasicMonoFont.addNewFont(ExMonoFont.Monaco);
		BasicMonoFont.addNewFont(null);
		
		BasicMonoFont.addNewFont(new MonoFont() {
			  @Override
			  public String getFontName() {
			    return "Shree";
			  }
			  @Override
			  public File getLocation() {
			    return new File("/Shree/fonts");
			  }
			  @Override
			  public String toString() {
				return getFontName();
			  }
			});
		
		System.out.println(BasicMonoFont.fonts());
		
		BasicMonoFont basicMonofont;
		ExMonoFont exMonoFont;
		
		MonoFont font=null;
		
		try {
			font = BasicMonoFont.monoFontFor("Shree11");
			if(font==null) {
				System.out.println("Font not found so program exit.");
				System.exit(-1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(font.getLocation());
		
		if(font instanceof BasicMonoFont) {
			basicMonofont = (BasicMonoFont) font;
			System.out.println(basicMonofont.getLocation());
		} else if(font instanceof ExMonoFont) {
			exMonoFont = (ExMonoFont) font;
			System.out.println(exMonoFont.getLocation());
		}
		
	}

	private static interface MonoFont {
		public String getFontName();
		public File getLocation();
	}
	
	private static enum BasicMonoFont implements MonoFont {
		
		Courier("Courier", new File("/Courier/fonts")),
		Consolas("Consolas", new File("/Consolas/fonts")),
		DejaVu("DejaVu", new File("/DejaVu/fonts"));
		
		private final String fontName;
		private final File   location;
		private static Map<String, MonoFont> map = new TreeMap <String, MonoFont>();
		
		static {
		    for (MonoFont font : BasicMonoFont.values()) {
		        map.put(font.getFontName(), font);
		    }
		}

		public static Collection<MonoFont> fonts() {
			return map.values();
		}
		
		public static MonoFont monoFontFor(String fontName) throws Exception {
		    return map.get(fontName);
		}
		
		public static boolean addNewFont(MonoFont font) {
			boolean addFlag=false;
			if(font!=null && !font.getFontName().isEmpty()) {
			   if (!map.containsKey(font.getFontName())) {
			     map.put(font.getFontName(), font);
			     addFlag=true;
			   }
			}
			return addFlag; 
		}
		
		private BasicMonoFont(String fontName, File location) {
		    this.fontName = fontName;
		    this.location = location;
		}
		 
		@Override
		public String getFontName() {
		   return fontName;
		}
		 
		@Override
		public File getLocation() {
		   return location;
		}
	}
	
	public static enum ExMonoFont implements MonoFont {
		 
		  Lucida("Lucida", new File("~/Lucida/fonts")),
		  Monaco("Monaco", new File("~/Monaco/fonts")),
		  Andale("Andale", new File("~/Andale/fonts"));
		 
		  private final String fontName;
		  private final File   location;
		 
		  private ExMonoFont(String fontName, File location) {
		    this.fontName = fontName;
		    this.location = location;
		  }
		 
		  @Override
		  public String getFontName() {
		    return fontName;
		  }
		 
		  @Override
		  public File getLocation() {
		    return location;
		  }
	}
	
}
