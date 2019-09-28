
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataClass {

  private static DataClass dataClass = new DataClass();       //singleton
  private List<Music> top100music;

  DataClass() {
    top100music = new ArrayList<>();
    getData();
  }

  static DataClass getInstance() {
    return dataClass;
  }

  public List<Music> getTop100music() {
    return top100music;
  }

  public void getData() {
    String s;
    String path = "D:/MusicPlayerProject/src/top100Music.txt";
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      while ((s = br.readLine()) != null) {
        String[] data = s.split("-");
        /* 불러온 데이터 저장 */
        top100music.add(new Music(data[0], data[1]));
      }
    } catch (IOException e) {
      //FileReader에 대한 예외처리
      e.printStackTrace();
    }
  }

  public void printTop100MusicList() {
    top100music.forEach(s -> System.out.println(s.getSinger() + "-" + s.getSong()));
  }

}
