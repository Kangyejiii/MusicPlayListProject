
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MusicList {
  /**
   * 객체로 List 저장하기
   * Music - Song / Singer
   */
  private List<Music> myPlayList;

  public MusicList() {                //Constructor
    myPlayList = new LinkedList<>();
  }

  public List<Music> getMyPlayList() {
    return myPlayList;
  }

  /*** 음악 리스트 출력*/
  public void printPlayList() {
    if(myPlayList.size()==0){
      System.out.println(" **EMPTY** ");
      return;
    }
    AtomicInteger i = new AtomicInteger(1);
    myPlayList.forEach(s -> System.out.println((i.getAndIncrement())+" "+s.getSong() + "-" + s.getSinger()));
  }

  /*** 음악 추가*/
  public void addMusic(Music music) {
    myPlayList.add(music);
  }

  /* 음악 삭제 */
  public void removeMusic() {
    if(myPlayList.size()==0){
      System.out.println(" **EMPTY** ");
      return;
    }
    printPlayList();
    System.out.println("삭제할 음악의 번호를 누르세요");
    System.out.println("이전메뉴가기: -1 ");
    Scanner sc = new Scanner(System.in);

    while (true) {
      int num = sc.nextInt();
      if (num <= myPlayList.size() && num > 0) {
        myPlayList.remove(num - 1);
        System.out.println("성공적으로 삭제되었습니다.");
        return ;
      } else if(num == -1 ){
        System.out.println("######");
        return;
      }
      else {
        System.out.println("다시입력해주세요");
      }
    }
  }
  }
