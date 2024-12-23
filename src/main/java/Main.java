import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app=new App();
        app.run();
    }
}

class App{
    public void run(){
//        == 명언 앱 ==
//        명령) 등록
//        명언 : 현재를 사랑하라.
//        작가 : 작자미상
//        1번 명언이 등록되었습니다.
//        명령) 등록
//        명언 : 현재를 사랑하라.
//        작가 : 작자미상
//        2번 명언이 등록되었습니다.
//        명령) 종료

        Scanner scanner=new Scanner(System.in);

        System.out.println("== 명언 앱 ==");

        int lastNo=0;

        while(true)
        {
            System.out.print("명령) ");
            String command=scanner.nextLine();

            if(command.equals("등록")){
                System.out.print("명언 : ");
                scanner.nextLine();
                System.out.print("작가 : ");
                scanner.nextLine();

                System.out.println(++lastNo+"번 명령이 등록되었습니다.");
            }
            else if(command.equals("종료")){
                break;
            }
        }
    }
}