
import java.util.Scanner;
import java.util.stream.Stream;

public class Search {

  private DataClass data;
  Search() {
    data = DataClass.getInstance();
  }
  /**
   * 가수로 검색
   */
  public void searchBySinger(final MusicList musicList, final String targetSinger) {
    Stream<Music> singer = data.getTop100music().stream()
        .filter(s -> s.getSinger().matches(".*" + targetSinger + ".*"));

    Music[] result = singer.toArray(Music[]::new);

    if (result.length != 0) {
      System.out.println(targetSinger + " 곡 List 입니다.");
      saveMusic(musicList, result);
    } else {
      System.out.println("찾으시는 결과가 없습니다.");
    }
  }

  /**
   * 곡으로 검색
   */
  public void searchBySong(final MusicList musicList, final String targetSong) {
    Stream<Music> song = data.getTop100music().stream()
        .filter(s -> s.getSong().matches(".*" + targetSong + ".*"));

    Music[] result = song.toArray(Music[]::new);

    if (result.length != 0) {
      System.out.println("'" + targetSong + "'으로 검색하신 결과입니다.\n");
      saveMusic(musicList,result);
    } else {             //song is null
      System.out.println("찾으시는 결과가 없습니다.");
    }
  }

  public int printResult(final Music[] result) {
    Scanner sc = new Scanner(System.in);

    for (int i = 0; i < result.length; i++) {
      System.out.println("[" + (i + 1) + "] " + result[i].getSong() + "-" + result[i].getSinger());
    }

    while (true) {
      System.out.println("곡의 번호를 입력하세요 ");
      System.out.println(" 이전 메뉴 가기 : -1 ");
      int i = sc.nextInt();
      if (i <= result.length && i > 0) {
        return i - 1;
      } else if (i == -1) {
        System.out.println("######이전 메뉴 가기####");
        return -1;
      } else {
        System.out.println("번호를 잘못입력하셨습니다.");
      }
    }
  }

  public void saveMusic(final MusicList musicList, final Music[] result) {
    int num = printResult(result);
    if(num != -1 ){
      musicList.addMusic(result[num]);
      System.out.println("성공적으로 음악을 저장했습니다.\n");
    }
  }

}

