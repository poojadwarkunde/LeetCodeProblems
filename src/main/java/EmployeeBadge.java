import java.util.*;

public class EmployeeBadge {
    public static void main(String[] args) {
        String[][] badgeRecords ={{"Paul", "enter"},{"Paul", "exit"},{"Paul", "exit"},{"Paul", "enter"}}; //// Expected output: ["Paul"], ["Paul"]
//                {{"Paul", "enter"},{"Paul", "enter"},{"Paul", "exit"},{"Paul", "exit"}}; //// Expected output: ["Paul"], ["Paul"]
//                {{"Paul", "enter"},{"Paul", "exit"}}; // Expected output: [], []
//                {{"Paul", "enter"},{"Paul", "exit"},{"Paul", "exit"},{"Paul", "enter"}, {"Martha", "enter"}, {"Martha", "exit"}};// Expected output: ["Paul"], ["Paul"]
//                {{"Paul", "enter"},{"Paul", "exit"},{"Paul", "exit"}}; // Expected output: [], ["Paul"]
//                {{"Paul", "enter"},{"Paul", "enter"},{"Paul", "exit"}}; // Expected output: ["Paul"], []
//                {{"Martha", "exit"}, {"Paul", "enter"}, {"Martha", "enter"}, {"Martha", "exit"}, {"Jennifer", "enter"}, {"Paul", "enter"},{"Curtis", "exit"}, {"Curtis", "enter"}, {"Paul", "exit"}, {"Martha", "enter"},{"Martha", "exit"}, {"Jennifer", "exit"}, {"Paul", "enter"}, {"Paul", "enter"}, {"Martha", "exit"}}; // Expected output: ["Curtis", "Paul"], ["Martha", "Curtis"]
        EmployeeBadge e = new EmployeeBadge();
        System.out.println(e.findEmpWhoDidNotSwipe(badgeRecords));
    }

    private List<List<String>> findEmpWhoDidNotSwipe(String[][] badgeRecords) {
        Map<String, String> m = new HashMap();
        Set<String> entrySet = new HashSet<>();
        Set<String> exitSet = new HashSet<>();
        List<List<String>> finalList = new ArrayList<>(2);

        for (int i = 0; i < badgeRecords.length; i++) {
            if (!m.containsKey(badgeRecords[i][0])) {
                if (badgeRecords[i][1].equals("enter")) {
                    m.put(badgeRecords[i][0], badgeRecords[i][1]);
                } else {
                    entrySet.add(badgeRecords[i][0]);
                }
            } else {
                if (badgeRecords[i][1].equals("exit") && m.get(badgeRecords[i][0]).equals("enter")) {
                    m.remove(badgeRecords[i][0]);
                } else {
                    exitSet.add(badgeRecords[i][0]);
                }
            }
        }

            for(Map.Entry e : m.entrySet()){
                if(e.getValue().equals("enter")){
                    exitSet.add(String.valueOf(e.getKey()));
                }else{
                    entrySet.add(String.valueOf(e.getKey()));
                }
            }
        System.out.println("Did not swipe while entering : "+entrySet);
        System.out.println("Did not swipe while exiting : " + exitSet);
        System.out.println(m);
        List entry = new ArrayList<>(entrySet);
        List exit = new ArrayList<>(exitSet);
        finalList.add(0,exit);
        finalList.add(1,entry);
        return finalList;
    }
}
