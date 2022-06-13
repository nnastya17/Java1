package com.films;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Введите кол-во фильмов:");
        int n = sc.nextInt(); //кол-во фильмов
        com.films.Film[] films = new com.films.Film[n];
        System.out.println("Введите информацию о фильмах:");
        for(int i=0; i< films.length; i++) //ввод
        {
            sc.nextLine();
            films[i] = new com.films.Film();
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
        for(com.films.Film c: films) //вывод
        {
            System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+ c.yearOfRelease + "\t\t" + c.cost);
        }
        //вызовы методов
        MinYear(films);
        CostHigherMedium(films);
        TitleTopSort(films);
        TitleSearch(films);
        EditFields(films);
    }

    public static void MinYear(Film arr[]) //вывести информацию о фильме самого раннего года выпуска;
    {
        int nmin = 0;
        int min = arr[nmin].yearOfRelease;
        for(int i = 0; i< arr.length; i++)
        {
            if(arr[i].yearOfRelease > min)
            {
                min = arr[i].yearOfRelease;
                nmin = i;
            }
        }
        System.out.println("Фильм самого раннего года выпуска:" + "\n");
        System.out.println("Название фильма: "+arr[nmin].title+"\n"+"Год выпуска: "+arr[nmin].yearOfRelease);
    }

    public static void CostHigherMedium(Film arr[]) //определить фильмы, стоимость проката которых выше средней;
    {
        int sum = 0;
        for(int i=0; i< arr.length; i++)
            sum+=arr[i].cost;
        double medium = sum/ arr.length; //среднее кол-во побед
        System.out.println("Средняя стоимость проката: " + medium);
        System.out.println("Фильмы со стоимостью проката выше среднего: " + "\n");
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i].cost>medium)
            {
                System.out.println("Название фильма: "+arr[i].title+"\n"+"Стоимость проката: "+arr[i].cost+"\n");
            }
        }
    }

    public static void TitleTopSort(Film arr[]) //упорядочить массив по названиям фильмов в алфавитном порядке;
    {
        for(int i=0; i < arr.length-1; i++)
        {
            for(int j=0; j < arr.length-1-i; j++)
            {
                if(arr[j].title.compareTo(arr[j+1].title)>0)
                {
                    Film temp = arr[j]; //временная переменная для перестановки
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("Отсортированный список по названию: ");
        System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                "\n"+"_____________________________________________________");
        for(int i=0; i< arr.length; i++){
            System.out.println(arr[i].title + "\t" + arr[i].country + "\t" + arr[i].genre + "\t\t"+
                    arr[i].yearOfRelease + "\t\t" + arr[i].cost);
        }
    }

    public static void TitleSearch(Film arr[]) //поиск по названию
    {
        Scanner sc = new Scanner(System.in, "cp1251");
        sc.nextLine();
        System.out.println("Введите название фильма чтобы найти его:");
        String search_title = sc.nextLine();
        int num = -1;
        for(int i=0; i< arr.length; i++)
        {
            if(search_title.equalsIgnoreCase(arr[i].title))
                num = i;
        }
        System.out.println("Найденые фильмы:");
        if(num != -1)
        {
            System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                    "\n"+"_____________________________________________________");
            System.out.println(arr[num].title + "\t" + arr[num].country + "\t" + arr[num].genre + "\t\t"+
                    arr[num].yearOfRelease + "\t\t" + arr[num].cost);
        }
        else System.out.println("Такого фильма нет.");
    }

    public static void EditFields(Film arr[]) //редактирование полей
    {
        Scanner sc = new Scanner(System.in, "cp1251");
        sc.nextLine();
        int s; //индекс команды по умолчанию
        System.out.println("Введите название фильма который хотите редактировать: ");
        String inputTitle = sc.nextLine();
        for(int i=0; i< arr.length; i++) {
            if (inputTitle.equalsIgnoreCase(arr[i].title)) {
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
        for(int i=0; i< arr.length; i++)
        {
            s=i;
            if(inputField == 1)
            {
                String t;
                System.out.println("Введите новое название фильма:");
                t = sc.nextLine();
                arr[s].title = t;
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: arr) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
            else if(inputField == 2)
            {
                System.out.println("Введите новую страну:");
                arr[s].country = sc.nextLine();
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: arr) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
            else if(inputField == 3)
            {
                System.out.println("Введите новый жанр:");
                arr[s].genre = sc.nextLine();
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: arr) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
            else if(inputField == 4)
            {
                System.out.println("Введите новый год выпуска:");
                arr[s].yearOfRelease = sc.nextInt();
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: arr) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
            else if(inputField == 5)
            {
                System.out.println("Введите новую стоимость проката:");
                arr[s].cost = sc.nextInt();
                System.out.println("Название"+"\t"+"Страна"+"\t"+"Жанр"+"\t"+"Год выпуска"+"\t"+"Стоимость проката"+
                        "\n"+"_____________________________________________________");
                for(Film c: arr) //вывод
                {
                    System.out.println(c.title + "\t" + c.country + "\t" + c.genre + "\t\t"+
                            c.yearOfRelease + "\t\t" + c.cost);
                }
            }
        }
    }
}