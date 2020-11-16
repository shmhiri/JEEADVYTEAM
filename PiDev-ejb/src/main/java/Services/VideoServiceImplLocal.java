package Services;
import java.util.List;

import javax.ejb.Local;

import Entities.*;




@Local
public interface VideoServiceImplLocal {

	public void uploadVideo(Video video);
	public boolean checkTitle(Video video);
	public List<Video> listAllVideo();
	public List<Video> rechercherVideo(String recherche);
	public int vuesOneVideo(Video video);
	public void deletevideo(Video video);
}
