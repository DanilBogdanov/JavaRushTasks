package com.javarush.task.task23.task2304;

public class Test {
    int x = 2;
    static int y = 1;

    class InnerClass {
        int iiii = 23;
        public void fuckinMethod() {

        }
    }

    public void metod() {
        InnerClass inner = new InnerClass() {
          int ss = x;

          private void metods() {
              System.out.println("asdf");
          }

          @Override
          public void fuckinMethod() {
              metods();
          }

        };
    }

    public static void main(String[] args) {
        InnerClass inner = new Test().new InnerClass() {

        };




    }
}


