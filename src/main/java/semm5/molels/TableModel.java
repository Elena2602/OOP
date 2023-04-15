package semm5.molels;

import semm5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TableModel implements Model {


    private Collection<Table> tables;

    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    public Map<Integer,Table> reservationMap = new HashMap<>();
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
        //throw new RuntimeException("Некорректный номер столика");
    }
    /**
     * TODO: Разработать самостоятельно
     * Поменять бронь столика
     * @param oldReservation номер старого резерва (для снятия)
     * @param reservationDate дата резерва столика
     * @param tableNo номер столика
     * @param name Имя
     */


    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        if (reservationMap.containsKey(oldReservation)){
            tables.add(new Table(reservationMap.get(oldReservation).no));
            reservationMap.remove(oldReservation);
            return reservationTable(reservationDate, tableNo, name);
        }
        return -1;
    }

    public void deleteReservation(int oldReservation){
        if (reservationMap.containsKey(oldReservation)){
            tables.add(new Table(reservationMap.get(oldReservation).no));
            System.out.printf("\nРезерв снят, столик #%d освободился", reservationMap.get(oldReservation).no);
            reservationMap.remove(oldReservation);
        }
        else System.out.println("\nТакого номера резерва не существует");
    }


}

