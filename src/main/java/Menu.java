import java.util.Scanner;

public class Menu {

  private Scanner sc = new Scanner(System.in);
  private Search search;
  private DataClass dataClass;
  private MusicList musicList;

  Menu() {
    dataClass = new DataClass();
    search = new Search();
    musicList = new MusicList();
  }

  void printMenu() {
    while (true) {
      System.out.println();
      System.out.println("------------");
      System.out.println("1. 인기차트");
      System.out.println("2. 검색하기/음악추가");
      System.out.println("3. 내 보관함");
      System.out.println("4. 내 보관함 음악삭제");
      System.out.println("5. 종료");
      System.out.println("------------");
      int i = sc.nextInt();

      switch (i) {
        case 1:
          dataClass.printTop100MusicList();     //1. top100Music에 있는 목록 출력
          break;
        case 2:
          printSearchMenu();                   //2. 검색하기
          break;
        case 3:
          musicList.printPlayList();            //3. 나의 보관함 출력하기
          break;
        case 4:
          musicList.removeMusic();              //4. 음악 삭제
          break;
        case 5:                                 //5. 종료
          return;
      }
    }
  }

  private void printSearchMenu() {
    String target;
    while (true) {
      System.out.println("검색할 방법을 선택해주세요");
      System.out.println("1 : 가수로 검색 ");
      System.out.println("2 : 노래제목으로 검색 ");
      System.out.println("3 : 메뉴로 돌아가기");
      int i = sc.nextInt();

      if (i == 1) {
        System.out.print("가수 > ");
        target = sc.next();
        search.searchBySinger(musicList, target.trim());
      } else if (i == 2) {
        System.out.print("노래제목 > ");
        target = sc.next();
        search.searchBySong(musicList, target.trim());
      } else if (i == 3) {
        return;
      } else {
        System.out.println("숫자가 아닙니다.");
      }
    }
  }

}