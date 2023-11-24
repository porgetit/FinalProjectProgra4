/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.futbol5;

import Connector.Create;
import Connector.Delete;
import Connector.Recover;
import Connector.Update;

public class Futbol5 {

    public static void main(String[] args) {
        Create.toInsert("Java2", "FREQUENT");
        System.out.println(Recover.toSelectByID(1).toString());
        Update.toUpdate(1, "Juan1", Recover.toSelectByID(1).getSubscriptionType());
        Delete.toDelete(13);
    }
}
