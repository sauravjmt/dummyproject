package simpleblockchain;

import java.util.Date;

public class Block {

	public String hash;
	public String previousHash;
	private String data; //our data will be a simple message.
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	
	public Block(String data, String previousHash) {
		
		
		this.previousHash = previousHash;
		this.data = data;
		this.timeStamp = new Date().getTime();
		this.hash=calculateHash();
	}
	
	
	
	public String calculateHash() {
		String calculatedhash = StringUtil.applySHA256( 
				previousHash +
				Long.toString(timeStamp) +
				data 
				);
		return calculatedhash;
	}
	
}
