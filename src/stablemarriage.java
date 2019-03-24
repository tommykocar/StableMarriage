


//Written by Thomas Kocar



/**
 * Class Stablemarriage
 **/
public class stablemarriage {
    private int N, engagedCount;
    private String[][] group1pref;
    private String[][] group2pref;
    private stack group1;
    private stack group2;
    private String[] Partner;
    private boolean[] peopleEngaged;

    /**
     * Constructor
     **/
    public stablemarriage(stack g1, stack g2, String[][] gp1, String[][] gp2, int numberofpairings) {
        N = numberofpairings ;
        engagedCount = 0;
        group1 = g1;
        group2 = g2;
        group1pref = gp1;
        group2pref = gp2;
        peopleEngaged = new boolean[N];
        Partner = new String[N];
        calcMatches();
    }

    /**
     * function to calculate all matches
     **/
    private void calcMatches() {
        while (engagedCount < N) {
            int free;
            for (free = 0; free < N; free++)
                if (!peopleEngaged[free])
                    break;

            for (int i = 0; i < N && !peopleEngaged[free]; i++) {
                int index = group2IndexOf(Integer.parseInt(group1pref[free][i]));
                if (Partner[index]== null) {
                    Partner[index] = String.valueOf(group1.get(free));
                    peopleEngaged[free] = true;
                    engagedCount++;
                }
                else {
                    String currentPartner = Partner[index];
                    if (morePreference(currentPartner, String.valueOf(group1.get(free)), index)) {
                        Partner[index] = String.valueOf(group1.get(free));
                        peopleEngaged[free] = true;
                        peopleEngaged[group1IndexOf(currentPartner)] = false;
                    }
                }
            }
        }
        printCouples();
    }

    /**
     * function to check if person prefers new partner over old assigned partner
     **/
    private boolean morePreference(String curPartner, String newPartner, int index) {
        for (int i = 0; i < N; i++) {
            int theirpref = Integer.parseInt((group2pref[index][i]));
            String desiredperson = String.valueOf(group1.get(theirpref));
            if (desiredperson.equals(newPartner))
                return true;
            if (desiredperson.equals(curPartner))
                return false;
        }
        return false;
    }

    /**
     * get group 1 index
     **/
    private int group1IndexOf(String str) {
        for (int i = 0; i < N; i++)
            if (group1.get(i).equals(str))
                return i;
        return -1;
    }

    /**
     * get group 2 index
     **/
    private int group2IndexOf(int str) {
        String partnerprefered = String.valueOf(group2.get(str));
        for (int i = 0; i < N; i++)
            if (group2.get(i).equals(partnerprefered))
                return i;
        return -1;
    }

    /**
     * print teams
     **/
    public void printCouples() {
        stack grouppairs = new stack();
        try {
        for (int j=0; j<N; j++){
                grouppairs.push(Partner[j]+" and "+ group2.get(j));
            }
        }catch (stackoverflowexception stackoverflowexception) {
            stackoverflowexception.printStackTrace();
        }
        for (int i = 0; i < N; i++) {
            System.out.println("Team " + i + ": " + grouppairs.get(i));
        }
    }
}
