package com.tgt.testGF;

import com.tgt.Entite.feedback;
import com.tgt.servicefeedback.servicefeedback;
import java.sql.SQLException;
import java.util.List;

public class testGF {
    
public static void main(String[] args) {

        //feedback f1=new feedback("feedback1", "bla bla bla", "whatever", "11/02/2020");
        servicefeedback serr = new servicefeedback();
        feedback f1 = new feedback(3, "bla bla bla", "11/02/2020");
        feedback f2 = new feedback(4, "ABC", "04/02/2019");
        // feedback f3 = new feedback(1, 0, "hohoho", "20/02/2021");
        try {
       // serr.ajouter(f1);
        
      //   serr.ajouter(f2);
        //  serr.deleteParID(2);
//            serr.update(f3);
         //   serr.readAllTri().forEach(System.out::println);

            List<feedback> list = serr.readAll();
            System.out.println(list);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
}
