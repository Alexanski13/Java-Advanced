package SetsAndMapsAdvancedExercise;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Integer>> usersMap = new TreeMap<>();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String ipParts = tokens[0];
            String userNameParts = tokens[2];
            String userName = userNameParts.substring(5);
            String ipAddress = ipParts.substring(3);

            if (!usersMap.containsKey(userName)) {
                usersMap.put(userName, new LinkedHashMap<>());
            }

            if (!usersMap.get(userName).containsKey(ipAddress)) {
                usersMap.get(userName).put(ipAddress, 1);
            } else {
                int ipAttacksCounter = usersMap.get(userName).get(ipAddress) + 1;
                usersMap.get(userName).put(ipAddress, ipAttacksCounter);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> attacker : usersMap.entrySet()) {
            System.out.printf("%s: %n", attacker.getKey());
            LinkedHashMap<String, Integer> attacks = attacker.getValue();
            StringBuilder sb = new StringBuilder();

            for (Map.Entry<String, Integer> singleAttack : attacks.entrySet()) {
                String formattedAttack = String.format("%s => %d, ", singleAttack.getKey(), singleAttack.getValue());
                sb.append(formattedAttack);
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            finalOutput = finalOutput + ".";

            System.out.println(finalOutput);
        }
    }
}
