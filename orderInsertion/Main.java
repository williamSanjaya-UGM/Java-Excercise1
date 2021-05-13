package orderInsertion;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        OrderList orders= new OrderList();
        String fileName = args[0];
        List<String> ordersList = readList(fileName);
        List<List<String>> collectOrder = ordersList.stream().map(s -> Arrays.asList(s.split(":"))).collect(Collectors.toList());

        int total_qty=0;
        try {
            FileWriter fw = new FileWriter("./newMyOrderList.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < collectOrder.size(); i++) {
                total_qty += Integer.parseInt(collectOrder.get(i).get(1).replace(" ", ""));
                orders.setOrderName(collectOrder.get(i).get(0));
                orders.setOrderQty(Integer.parseInt(collectOrder.get(i).get(1).replace(" ", "")));
                bw.write(String.valueOf(orders));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(total_qty);
    }

    private static List<String> readList(String file) {
        List<String> orderList = new ArrayList<>();
        try(FileInputStream fis = new FileInputStream(file)) {
            StringBuilder sb = new StringBuilder();
            int c=0;
            while((c= fis.read())!=-1) {
                sb.append(Character.toString(c));
            }
            String[] split = sb.toString().replaceAll(",",":").split("\r\n");
            orderList.addAll(Arrays.asList(split));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
