package Ppe;

import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Database database = new Database();
        List list = new ArrayList();
        List list2 = new ArrayList();
        list2.add("При посещении нефтеперерабатывающих дополнительно:");
        list2.add("На наружных работах зимой дополнительно:");
        list2.add("При управлении грузовыми и специальными автомобилями, автокраном, тягачом:");
        list2.add("При управлении легковым автомобилем при посещении производственных участков:");
        list2.add("При управлении автобусом, микроавтобусом при посещении производственных участков:");
        list2.add("Зимой дополнительно:");
        list2.add("При выполнении работ по мытью полов и мест общего пользования дополнительно:");
        database.Connection();
        String condition = "";
        DataFormatter dataFormatter = new DataFormatter();
        file file = new file();
        var printStream = file.createFile();
        WorkcBoock workcBoock = new WorkcBoock();
        for (int k = 0; k < 21 ; k++) {
            var s = workcBoock.WorkcBoock(k);
            for (int i = 0; i < s.getPhysicalNumberOfRows(); i++)
            {
                var Position = dataFormatter.formatCellValue(s.getRow(i).getCell(0)).trim();
                if (Position == "")
                {
                    //System.out.println(String.format("Лист %s закончен-------------------------------",k));
                    break;
                }else
                {
                    var Result2 = database.statement1.executeQuery("SELECT id,Name\n" +
                            "    From Positions");
                    while (Result2.next()) {
                        var id = Result2.getString(1).trim();
                        var NamePos = Result2.getString(2).trim();
                        if (Position.trim().equals(NamePos)) {
                            var Result3 = database.statement2.executeQuery("SELECT id,PositionId\n" +
                                    "FROM StaffingTables");
                            while (Result3.next()) {
                                var Sataffid = Result3.getString(1).trim();
                                var Posid = Result3.getString(2).trim();
                                if (id.equals(Posid)) {
                                    list.add(Sataffid);
                                }
                            }
                        }
                    }
                    for ( int j = 0; j < s.getPhysicalNumberOfRows(); j++)
                    {
                        var PpeType = dataFormatter.formatCellValue(s.getRow(j).getCell(1)).trim();
                        var Quain = dataFormatter.formatCellValue(s.getRow(j).getCell(2)).trim();
                        var Years = dataFormatter.formatCellValue(s.getRow(j).getCell(3)).trim();
                        if (PpeType.equals("123456"))
                        {
                            //System.out.println(String.format("Лист %s закончен-------------------------------",k));
                            list.clear();
                            break;
                        } else {
                            for (var dd : list) {
                                var Result = database.statement.executeQuery("SELECT id,Name\n" +
                                        "From PpeTypes\n" +
                                        "where id between 79 and 140");
                                while (Result.next()) {
                                    var id = Result.getString(1);
                                    var Name = Result.getString(2).trim();
                                    if (PpeType.equals(Name)) {
                                        System.out.println(dd + "\t" + id + "\t" + condition + "\t" + Quain + "\t" + Years);
                                        printStream.println(dd + "\t" + id + "\t" + condition + "\t" + Quain + "\t" + Years);
                                    }
                                    for (var sda : list2) {
                                        if (PpeType.equals(sda)) {
                                            condition = PpeType;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                condition = "";
            }
        }
    }
}
