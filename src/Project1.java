


//Written by Thomas Kocar

import java.io.*;


public class Project1 {
    /**main function
     *
     * @param args
     */
        public static void main(String[] args) {
            try {
                BufferedReader Players = new BufferedReader(new FileReader("test.txt" ));
                System.out.println("Stable Marriage Algorithm\n");
                 int numberofpairings= new Integer(Players.readLine());
                 int counter= 0;
                stack group1 = new stack();
                stack group2= new stack();
                String[][] g1p = new String[numberofpairings][numberofpairings];
                String[][] g2p= new String[numberofpairings][numberofpairings];
                /** puts together the two stack groups and puts together the two preference arrays **/
                for (int i = 0; i <numberofpairings*2; i++) {
                    if (i < numberofpairings) {

                        /**reads name and preferences from the file**/
                        String Person = Players.readLine();
                        String lineofpref = Players.readLine();
                        String[] splitpref = lineofpref.split("\\h");

                        /** stack of group1 **/
                        group1.push(Person);
                        /** group 1 Preferences **/
                        for (int j = 0; j < splitpref.length; j++) {
                            g1p[i][j] = splitpref[j];
                        }
                    } else if (i >= numberofpairings && i < numberofpairings * 2) {

                        /**reads name and preferences from the file**/
                        String Person = Players.readLine();
                        String lineofpref = Players.readLine();
                        String[] splitpref = lineofpref.split("\t");

                        /**stack of group2 **/
                        group2.push(Person);

                        /** group 2 Preferences **/
                        for (int j = 0; j < splitpref.length; j++) {
                            g2p[counter][j] = splitpref[j];
                        }
                        counter++;
                    }
                }
                stablemarriage ms = new stablemarriage(group1, group2, g1p, g2p, numberofpairings);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (stackoverflowexception stackoverflowexception) {
                stackoverflowexception.printStackTrace();
            }


        }
    }