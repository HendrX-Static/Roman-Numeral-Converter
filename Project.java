import java.util.Scanner;

class rti{
    String rom;
    int action(){ 
    int a=0;
    boolean flag=false;
      for (int i=0; i<rom.length(); i++){
        char b = rom.charAt(i);
        if (flag==true)
          flag=false;
        else{
        if (i+1==rom.length()){
        if (b=='I') a+=1;
        else if (b=='V') a+=5;
        else if (b=='X') a+=10;
        else if (b=='L') a+=50;
        else if (b=='C') a+=100;
        else if (b=='D') a+=500;
        else if (b=='M') a+=1000;
        }
        else{
          char c = rom.charAt(i+1);
          if (b=='I'){
            if (c=='V') {a+=4;flag=true;}
            else if (c=='X') {a+=9;flag=true;}
            else a+=1;}
          else if (b=='V') a+=5;
          else if (b=='X') {
            if (c=='L') {a+=40;flag=true;}
            else if (c=='C') {a+=90;flag=true;}
            else a+=10;}
          else if (b=='L') a+=50;
          else if (b=='C') {
          if (c=='D') {a+=400;flag=true;}
          else if (c=='M') {a+=900;flag=true;}
          else a+=100;}
          else if (b=='D') a+=500;
          else if (b=='M') a+=1000;
        }
      }
      }
      return a;
    }
}

class itr{
    int rom;
    String action(){
        try{
            String[] a = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
            String[] b = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
            String[] c = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
            String[] d = {"","M","MM","MMM"};
            return (d[rom/1000]+c[(rom%1000)/100]+b[(rom%100)/10]+a[rom%10]);}
        catch(ArrayIndexOutOfBoundsException e){
            return "error";
        }
    }
}

class Project{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        rti a = new rti();
        itr b = new itr();
        System.out.print("Welcome!\nThis is a program that can be used to convert roman numerals to integer and vice versa.\nSo, what would you like to do?\n>[Type 1] Roman to Integer\n>[Type 2] Integer to Roman\n>[Type 3] Exit\n>>");
        int i = sc.nextInt();
        while (true){
            if (i==1){
                System.out.print("Enter the Roman Numeral: ");
                a.rom=sc.next();
                int ans=a.action();
                if (ans>3999) System.out.println("Invalid Roman Numeral!");
                else System.out.println("Integer: "+ans);
            }
            else if (i==2){
                System.out.print("Enter the Integer: ");
                b.rom=sc.nextInt();
                String ans = b.action();
                if (ans=="error") System.out.println("Integer must be under 4000!");
                else System.out.println("Roman Numeral: "+ans);
            }
            else break;
            System.out.print("Would you like to continue:\n>[Type 1] Roman to Integer\n>[Type 2] Integer to Roman\n>[Type 3] Exit\n>>");
            i=sc.nextInt();
        }
        sc.close();
        System.out.println("Thank You, Goodbye!");
    }
  }