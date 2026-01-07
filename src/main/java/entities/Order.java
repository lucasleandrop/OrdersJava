package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> itemList = new ArrayList<>();
    private static final SimpleDateFormat sdfOrder = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order(Date moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public Order() {
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item){
        itemList.add(item);

    }

    public void removeItem(OrderItem item){
        itemList.remove(item);

    }

    public Double total(){
        double sum = 0.0;

        for (OrderItem item : itemList){
            sum += item.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("--- DADOS DO PEDIDO ---\n");
        sb.append("Momento do Pedido: ").append(sdfOrder.format(moment)).append("\n");
        sb.append("Status do Pedido: ").append(status).append("\n");

        // Se você adicionou o campo Client, descomente a linha abaixo:
        // sb.append("Cliente: ").append(client.toString()).append("\n");

        sb.append("\nITENS DO PEDIDO:\n");

        // Itera sobre os itens para imprimir o resumo de cada um
        for (OrderItem item : itemList) {
            sb.append("  ").append(item.toString()).append("\n");
        }

        // --- CALCULA E ADICIONA O TOTAL FINAL ---
        sb.append("\nValor Total do Pedido: R$ ").append(String.format("%.2f", total())).append("\n");
        sb.append("---------------------------------\n");

        return sb.toString();
    }
}
