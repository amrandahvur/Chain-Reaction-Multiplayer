package withoutGUI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class gameSave implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	public void serialize(gameState gs) throws IOException
	{
		ObjectOutputStream out = null;
		try
		{
			out = new ObjectOutputStream(new FileOutputStream("gameState.db"));
			out.writeObject(gs);
		}
		finally
		{
			out.close();
		}
	}
	
	public gameState deserialize() throws IOException, ClassNotFoundException
	{
		ObjectInputStream in = null;
		try
		{
			in = new ObjectInputStream(new FileInputStream("gameState.db"));
			gameState GS = (gameState) in.readObject();
			return GS;
		}
		finally
		{
			in.close();
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
