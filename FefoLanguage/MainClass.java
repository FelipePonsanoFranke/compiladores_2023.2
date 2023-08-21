import java.util.Scanner;
public class MainClass{
public static void main(String args[]){
Scanner scanner = new Scanner(System.in);
double b;
int var3;
boolean var2;
boolean var1;
var3 = scanner.nextInt();
var3 = 1+2-4/2*8+13;
System.out.println("O valor de var3 é: ");
System.out.println(var3);
var2 = 3>1;
var1 = var3!=2;
while (var1){
if (var2){
System.out.println("var2 era verdadeira, por isso eu apareci");
}
else {
System.out.println("Só apareci pois var2 era falsa");
}
var2 = "abcd"=="dcba";
var3 = var3+1;
var1 = var3<2;
}
}
}
