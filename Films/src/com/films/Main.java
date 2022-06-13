package com.films;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите кол-во фильмов:");
        int n = sc.nextInt(); //кол-во фильмов
        Film[] films = new Film[n];
        System.out.println("Введите информацию о фильмах:");
        for(int i=0; i< films.length; i++) //ввод
        {
            sc.nextLine();
            films[i] = new Film();
            System.out.print("Введите название " + (i+1) + "-го фильма: ");
            films[i].title = sc.nextLine();
            System.out.print("Введите страну " + (i+1) + "-го фильма: ");
            films[i].country = sc.nextLine();
            System.out.print("Введите жанр " + (i+1) + "-го фильма: ");
            films[i].genre = sc.nextLine();
            System.out.print("Введите год выпуска " + (i+1) + "-го фильма: ");
            films[i].yearOfRelease = sc.nextInt();
            System.out.print("Введите стоимость проката " + (i+1) + "-го фильма: ");
            films[i].cost = sc.nextInt();
        }
        System.out.println("Характеристики фильма:");
        System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                "\n"+"_____________________________________________________");
        for(Film c: films) //вывод
        {
            System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+ c.yearOfRelease + "\t\t" + c.cost);
        }


        //вывести информацию о фильме самого раннего года выпуска;
        int nmin = 0;
        int min = films[nmin].yearOfRelease;
        for(int i = 0; i< films.length; i++)
        {
            if(films[i].yearOfRelease < min)
            {
                min = films[i].yearOfRelease;
                nmin = i;
            }
        }
        System.out.println("Фильм самого раннего года выпуска:" + "\n");
        System.out.println("Название фильма: "+films[nmin].title+"\n"+"Год выпуска: "+films[nmin].yearOfRelease);


        //определить фильмы, стоимость проката которых выше средней;
        int sum = 0;
        for(int i=0; i< films.length; i++)
            sum+=films[i].cost;
        double medium = sum/ films.length;
        System.out.println("Средняя стоимость проката: " + medium);
        System.out.println("Фильмы со стоимостью проката выше среднего: " + "\n");
        for(int i=0; i<films.length; i++)
        {
            if(films[i].cost>medium)
            {
                System.out.println("Название фильма: "+films[i].title+"\n"+"Стоимость проката: "+films[i].cost+"\n");
            }
        }


        //упорядочить массив по названиям фильмов в алфавитном порядке;
        for(int i=0; i < films.length-1; i++)
        {
            for(int j=0; j < films.length-1-i; j++)
            {
                if(films[j].title.compareTo(films[j+1].title)>0)
                {
                    Film temp = films[j];
                    films[j] = films[j+1];
                    films[j+1] = temp;
                }
            }
        }
        System.out.println("Отсортированный список по названию: ");
        System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                "\n"+"_____________________________________________________");
        for(int i=0; i< films.length; i++){
            System.out.println(films[i].title + "\t" + films[i].country + "\t" + films[i].genre + "\t\t"+
                    films[i].yearOfRelease + "\t\t" + films[i].cost);
        }


        //поиск по названию
        sc.nextLine();
        System.out.println("Введите название фильма чтобы найти его:");
        String search_title = sc.nextLine();
        int num = -1;
        for(int i=0; i< films.length; i++)
        {
            if(search_title.equalsIgnoreCase(films[i].title))
                num = i;
        }
        System.out.println("Найденые фильмы:");
        if(num != -1)
        {
            System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                    "\n"+"_____________________________________________________");
            System.out.println(films[num].title + "\t" + films[num].country + "\t" + films[num].genre + "\t\t"+
                    films[num].yearOfRelease + "\t\t" + films[num].cost);
        }
        else System.out.println("Такого фильма нет.");


        //редактирование полей
        sc.nextLine();
        int s;
        System.out.println("Введите название фильма который хотите редактировать: ");
        String inputTitle = sc.nextLine();
        for(int i=0; i< films.length; i++) {
            if (inputTitle.equalsIgnoreCase(films[i].title)) {
            }
            else
            {
                System.out.println("Такого фильма нет.");
                break;
            }
        }
        System.out.println("Выберите поле которое хотите редактировать: " + "\n" +
                "1 - название" + "\n" +
                "2 - страна" + "\n" +
                "3 - жанр" + "\n" +
                "4 - год выпуска" + "\n" +
                "5 - стоимость проката");
        int inputField = sc.nextInt();
        sc.nextLine();
        for(int i=0; i< films.length; i++)
        {
            s=i;
            if(inputField == 1)
            {
                String t;
                System.out.println("Введите новое название фильма:");
                t = sc.nextLine();
                films[s].title = t;
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: films) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
            else if(inputField == 2)
            {
                System.out.println("Введите новую страну:");
                films[s].country = sc.nextLine();
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: films) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
            else if(inputField == 3)
            {
                System.out.println("Введите новый жанр:");
                films[s].genre = sc.nextLine();
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: films) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
            else if(inputField == 4)
            {
                System.out.println("Введите новый год выпуска:");
                films[s].yearOfRelease = sc.nextInt();
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: films) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
            else if(inputField == 5)
            {
                System.out.println("Введите новую стоимость проката:");
                films[s].cost = sc.nextInt();
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: films) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
       }
    }
}