package semm6.spr2;


import java.io.FileWriter;
import java.io.IOException;


public class SaveToXML {

    Order saveOrder;

    public SaveToXML(Order saveOrder) {
        this.saveOrder = saveOrder;
    }

    public void saveToXML() {
        String fileName = "OOP/Seminars/sem_6/spr2/order.xml";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\""+ saveOrder.getClientName() + "\",\n");
            writer.write("\"product\":\""+saveOrder.getProduct()+"\",\n");
            writer.write("\"qnt\":"+saveOrder.getQnt()+",\n");
            writer.write("\"price\":"+saveOrder.getPrice()+"\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}