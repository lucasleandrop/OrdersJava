import entities.*;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date moment = new Date();
        List<Order> orderList = new ArrayList<>();

        Order order = new Order(moment,OrderStatus.PENDING_PAYMENT);

        System.out.println("Digite o nome do cliente:");
        String name = sc.nextLine();
        System.out.println("Digite o email do cliente:");
        String email = sc.nextLine();
        System.out.println("Digite a data de nascimento do cliente (DD/MM/AAAA): ");
        String dataTexto = sc.nextLine();
        Date bday = sdf.parse(dataTexto);
        Client client = new Client(name,email,bday);



        System.out.println("Digite os dados do pedido: ");
        System.out.println("Quantidade de itens: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nome do " + (i+1) + "º produto:");
            String nameProduct = sc.nextLine();
            System.out.println("Preço do " + (i+1) + "º produto:");
            double priceProduct = sc.nextDouble();
            System.out.println("Quantidade do " + (i+1) + "º produto:");
            int quantityProduct = sc.nextInt();
            sc.nextLine();
            Product product = new Product(nameProduct,priceProduct);
            OrderItem orderItem = new OrderItem(quantityProduct,product);

            order.addItem(orderItem);

        }
        System.out.println(client);
        System.out.println(order);
    }
}
