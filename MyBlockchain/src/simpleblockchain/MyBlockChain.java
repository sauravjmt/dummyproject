package simpleblockchain;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class MyBlockChain {
	
	static ArrayList<Block> blocks;
	
	public static void main(String[] args) {
		
		 blocks=new ArrayList<>();
		
		
		blocks.add(new Block("Hi i am the first block","0"));
		blocks.add(new Block("I am the second block", blocks.get(blocks.size()-1).hash));
		blocks.add(new Block("I am the third block ", blocks.get(blocks.size()-1).hash));
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blocks);		
		System.out.println(blockchainJson);
	}
	
	
	public static boolean isBlockValid() {
		
		Block currentBlock;
		Block previousBlock;
		
		for (int i = 1; i < blocks.size(); i++) {
			currentBlock=blocks.get(i);
			previousBlock=blocks.get(i-1);
			
			if(!currentBlock.hash.equals(currentBlock.calculateHash())){
				return false;
			}
			
			if(!currentBlock.previousHash.equals(previousBlock.previousHash)){
				return false;
			}
			
		}
		
		return true;
		
	}

}
