package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            yourFile = new File("D:/1.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            User danil = new User();
            danil.setFirstName("Danil");
            danil.setLastName("Bogdanov");
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
            danil.setBirthDate((sdf.parse("14.04.86")));
            System.out.println(danil.getBirthDate());
            danil.setMale(true);
            danil.setCountry(User.Country.RUSSIA);

            User immigrantGirl = new User();
            immigrantGirl.setFirstName("Baby");
            immigrantGirl.setLastName("Honey");
            immigrantGirl.setBirthDate(sdf.parse("3.04.88"));
            immigrantGirl.setMale(false);
            immigrantGirl.setCountry(User.Country.UKRAINE);

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(danil);
            javaRush.users.add(immigrantGirl);
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println("it's went good? -- " + javaRush.equals(loadedObject));
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                writer.write("JavaRush");
                writer.newLine();
                writer.write("Users:" + users.size());
                for (int i = 0; i < users.size(); i++) {
                    User user = users.get(i);
                    writer.newLine();
                    writer.write("User" + (i + 1));
                    writer.newLine();
                    writer.write("\tfirstName:" + user.getFirstName());
                    writer.newLine();
                    writer.write("\tlastName:" + user.getLastName());
                    writer.newLine();
                    writer.write("\tbirthDate:" + user.getBirthDate().getTime());
                    writer.newLine();
                    writer.write("\tisMale:" + user.isMale());
                    writer.newLine();
                    writer.write("\tcountry:" + user.getCountry().getDisplayName());
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                if ("JavaRush".equals(reader.readLine())) {
                    int countUsers = Integer.parseInt(reader.readLine().substring("Users:".length()));
                    for (int i = 0; i < countUsers; i++) {
                        User user = new User();
                        reader.readLine();// title "User"
                        user.setFirstName(reader.readLine().substring("\tfirstName:".length()));
                        user.setLastName(reader.readLine().substring("\tlastName:".length()));
                        long dateTime = Long.parseLong(reader.readLine().substring("\tbirthDate:".length()));
                        user.setBirthDate(new Date(dateTime));
                        user.setMale(Boolean.parseBoolean(reader.readLine().substring("\tisMale:".length())));
                        String countryLoad = reader.readLine().substring("\tcountry:".length());
                        for (User.Country country : User.Country.values()) {
                            if (country.getDisplayName().equals(countryLoad)) {
                                user.setCountry(country);
                                break;
                            }
                        }
                        users.add(user);
                    }
                } else {
                    System.out.println("Is not javaRush file");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
