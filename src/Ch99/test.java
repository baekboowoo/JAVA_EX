package Ch99;

class Customer{
	   private int MyWallet;
	   private int SnackCnt;
	   
	   
	   public Customer(int myWallet, int snackCnt) {
	      MyWallet = myWallet;
	      SnackCnt = snackCnt;
	   }
	   
	   public void Payment(Market market,int wallet )
	   {
	      //1 MyWallet에서 wallet만큼 차감
	      MyWallet-=wallet;
	      //2 Market에게 wallet전달,//3 market으로부터 사과개수받기
	      int cnt= market.Receive(wallet);
	      //4 과자개수를 멤버인 SnackCnt 누적
	      SnackCnt+=cnt;
	   }
	   public void ShowInfo() {
	      //속성 정보를 Console에 출력
	      System.out.println("보유 잔액 : "+ MyWallet);
	      System.out.println("과자 개수 : "+ SnackCnt);
	   }
	}

	class Market{
	   private int MyWallet;
	   private int SnackCnt;
	   public int Price;
	   
	   public Market(int myWallet, int snackCnt, int price) {
	      MyWallet = myWallet;
	      SnackCnt = snackCnt;
	      Price = price;
	   }
	   public int Receive(int wallet) {
	      //1 money 를 MyMoney 에 누적
	      MyWallet+=wallet;
	      //2 money 에 해당되는 만큼 과자개수를 계산
	      int revcnt=wallet/Price;
	      //2 SnackCnt에서 계산된 만큼의 과자개수를 차감
	      SnackCnt-=revcnt;
	      //3 계산된 과자 개수를 리턴한다
	      return revcnt;
	   }
	   public void ShowInfo() {
	      //속성 정보를 Console에 출력
	      System.out.println("보유 잔액 : "+ MyWallet);
	      System.out.println("과자 개수 : "+ SnackCnt);
	      System.out.println("개당 가격 : "+ Price);

	   }
	}



public class test {

	
		

		   public static void main(String[] args) {
		      Market 과자매장1 = new Market(100000,100,3500); ////보유잔액, 과자개수, 개당가격
		      Customer 백승하 = new Customer(10000,0); //보유잔액, 과자개수
		      Customer 김승훈 = new Customer(20000,0); //보유잔액, 과자개수
		      Customer 고길동 = new Customer(30000,0); //보유잔액, 과자개수
		      Customer 정세인 = new Customer(1500000,0); //보유잔액, 과자개수
		      Customer 송재욱 = new Customer(100000,0); //보유잔액, 과자개수
		      백승하.Payment(과자매장1, 3500);
		      김승훈.Payment(과자매장1, 10500);
		      정세인.Payment(과자매장1, 70000);
		      송재욱.Payment(과자매장1, 14000);
		      System.out.println("---과자매장 정보---");
		      과자매장1.ShowInfo();
		      System.out.println(" ");
		      System.out.println("---백승하 정보---");
		      백승하.ShowInfo();
		      System.out.println(" ");
		      System.out.println("---김승훈 정보---");
		      김승훈.ShowInfo();
		      System.out.println(" ");
		      System.out.println("---정세인 정보---");
		      정세인.ShowInfo();
		      System.out.println(" ");
		      System.out.println("---송재욱 정보---");
		      송재욱.ShowInfo();
		      
		   }

		}

