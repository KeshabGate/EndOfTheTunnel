import java.util.*;
import java.io.*;

class BingoCards{
	static public void main(String[] args) throws java.io.FileNotFoundException, IOException{
		ArrayList<String> constellations = new ArrayList<String>();
		
		File constellationNames = new File("ConstellationList.txt");
		FileWriter fileWriter = new FileWriter("Boards.txt");
		PrintWriter printWriter = new PrintWriter(fileWriter);
		Scanner s = new Scanner(constellationNames);

		while(s.hasNextLine()){
			constellations.add(s.nextLine());
		}
		
		ArrayList<String> lines = new ArrayList<String>();
		
		String[][] currentCard = makeCard(constellations);

		for(int i = 0; i<4; i++){
			String line = "";
			for(int j = 0; j<4; j++){
				String addition = currentCard[i][j] + "\t"; 
				line += addition;
			}
			lines.add(line);
		}

		for(String y : lines){
			printWriter.println(y);
		}
		printWriter.close();
	}
	
	static public String[][] makeCard(ArrayList<String> x){
		String[][] board = new String[4][4];
		for(int i = 0; i<16; i++){
			int index = (int) (Math.random() * x.size());
			System.out.println(index);
			int row = i/4;
			int col = i%4;
			board[row][col] = x.get(index);
			x.remove(index);
		}
		return board;
	}
}