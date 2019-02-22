package main.study.machineLearning;
import java.util.Arrays;

public class MachineLearning {

	//https://becominghuman.ai/making-a-simple-neural-network-2ea1de81ec20
	
	private static int input[] = { 0, 0, 1, 0 };
	private static float weights[] = { 0, 0, 0, 0 };
	private static float desiredResult = 1;
	private static float learningRate = 0.2F;
	private static int trials = 6;
	private static float neuralNetResult;
	
	public static void main(String[] args) {
		//train(trials); //Training under number of trials
		train(); //Training until desired output get
		testingModel(new int[]{1,0,0,0});
		testingModel(new int[]{0,1,0,0});
		testingModel(new int[]{0,0,0,1});
		
		testingModel(new int[]{0,0,1,0});
		testingModel(new int[]{0,0,-1,0});
		testingModel(new int[]{1,0,1,0});
	}

	private static float evaluateNeuralNetwork(int inputVector[], float weightVector[]) {
		System.out.println("Evaluate Neural Network start");
		float result = 0;
		float layer_value = 0;
		for (int index=0; index<inputVector.length; index++) {
			layer_value = inputVector[index] * weightVector[index];
			result += layer_value;
			System.out.println("Layer Result "+layer_value+ " Summation:"+result);
		}
		System.out.println("Evaluate Neural Network end");
		return result;
	}

	private static float evaluateNeuralNetError(float desired, float actual) {
		return (desired - actual);
	}

	private static void learn(int inputVector[], float weightVector[]) {
		System.out.println("Learning of Neural Network start");
		int index = 0;
		for (float weight : weightVector) {
			if (inputVector[index] > 0) {
				weights[index] = (weight + learningRate);
			}
			index++;
		}
		System.out.println("Learning of Neural Network end");
	}
	
	private static void train(int trials) {
		System.out.println("Training under number of trials start");
		float error=-1;
		for (int i = 0; i < trials; i++) {
			neuralNetResult = evaluateNeuralNetwork(input, weights);
			error = evaluateNeuralNetError(desiredResult, neuralNetResult);
			System.out.println("Neural Net output: " + neuralNetResult +" Error: "+ error + " Weight Vector: " + Arrays.toString(weights));
			if(error==0) break;
			learn(input, weights);
		}
		System.out.println("Training under number of trials end");
	}
	
	private static void train() {
		System.out.println("Training until desired output get start");
		float error=-1;
		do {
			neuralNetResult = evaluateNeuralNetwork(input, weights);
			error = evaluateNeuralNetError(desiredResult, neuralNetResult);
			System.out.println("Neural Net output: " + neuralNetResult +" Error: "+error + " Weight Vector: " + Arrays.toString(weights));
			if(error!=0) {
				learn(input, weights);
			}
		} while(error!=0);
		
		System.out.println("Training until desired output get end");
	}
	
	private static void testingModel(int inputVector[]) {
		//run train() or train(trials) method before running this method 
		neuralNetResult = evaluateNeuralNetwork(inputVector, weights);
		if(neuralNetResult==desiredResult) {
			System.out.println("Testing input "+Arrays.toString(inputVector)+" Result : I got Veg burgger");
		} else {
			System.out.println("Testing input "+Arrays.toString(inputVector)+" Result : No Veg burgger");
		}
		
	}
	
}
