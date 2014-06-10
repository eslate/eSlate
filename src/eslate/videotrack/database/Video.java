package eslate.videotrack.database;
//This class is used to keep the records of VideoTrrack.
public class Video {
	private int id;
	public Video() {
		// TODO Auto-generated constructor stub
	}
	//construct value for id
	public Video(int id)
	{
		this.id=id;
	}
	//setter method for setting ID
	public void setId(int id)
	{
		this.id=id;
	}
	//Getter method for getting the id
	public int getId()
	{
		return id;
	}

}
