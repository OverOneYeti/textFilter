import java.util.Locale;
import java.util.ArrayList;
import java.util.Locale;

public class Less {

    public static void filter( String str, int muchOfSymbols){
//--------------------------------------------------------------ВВОД
        //Пусть она х она будет хх

        str+=" ";  //первая фильтрация работает, если последний символ не буква
        System.out.println(str+"\n");
        //--------------------------------------------------------------ВВОД
//--------------------------------------------------------------ПЕРВАЯ ФИЛЬТРАЦИЯ
        char[] arraySymbol = str.toCharArray();  //массив символов первоначальной строки
        ArrayList<String> repeat = new ArrayList<>();  //массив слов, длиной <4
        String world= "";
        boolean post = false;
        String worldWithPostfix = "";
        //фильтрация слов, длиной <4
        for (char c : arraySymbol) {
            if (Character.isLetter(c)) {   //является ли чар буквой
                world += c;  //составляем из символов слово
            } else {
                //--------------------------------------------------------------ПОСТФИКС
                //постфиксальное замечание
                if (c == '-') {
                    worldWithPostfix = world;
                    post = true;
                } else {
                    if (post) {
                        if (world.equals("ся") || world.equals("сь") || world.equals("те") || world.equals("то") || world.equals("ка") || world.equals("либо") || world.equals("таки") || world.equals("нибудь")) {
                            worldWithPostfix += world;
                            world = worldWithPostfix;
                        } else {
                            repeat.add(worldWithPostfix);
                        }
                        post = false;
                    }
                }
//--------------------------------------------------------------ПОСТФИКС
//--------------------------------------------------------------
                if (world.length() != 0 && world.length() < muchOfSymbols && !post) { //если слово, а не \n и др.символы
                    world = world.toLowerCase(Locale.ROOT);  //переводим слово в нижний регистр
                    repeat.add(world);  //добавляем слово в массив слов, длиной <4
                }
                world = "";
//--------------------------------------------------------------
            }
        }
//--------------------------------------------------------------ПЕРВАЯ ФИЛЬТРАЦИЯ
//--------------------------------------------------------------ВТОРАЯ ФИЛЬТРАЦИЯ
        StringBuilder newStroke = new StringBuilder();  //отфильтрованная строка
        StringBuilder postfix;
        int firstLengthWorldWithPostfix=0;
        worldWithPostfix="";
        for(int p=0;p<arraySymbol.length;p++)  //окончательная фильтрация
        {
            if(Character.isLetter(arraySymbol[p])) {   //является ли чар буквой
                world+=arraySymbol[p];
            }
            else {
                //--------------------------------------------------------------ПОСТФИКС
                //постфиксальное замечание
                if(arraySymbol[p]=='-'){
                    postfix = new StringBuilder();
                    for (int k=p+1;k<p+7;k++){
                        postfix.append(arraySymbol[k]);
                        if(postfix.toString().equals("ся")|| postfix.toString().equals("сь")|| postfix.toString().equals("те")|| postfix.toString().equals("то")|| postfix.toString().equals("ка")|| postfix.toString().equals("либо")|| postfix.toString().equals("таки")|| postfix.toString().equals("нибудь")){
                            firstLengthWorldWithPostfix=world.length();
                            worldWithPostfix=world;
                            worldWithPostfix+=postfix;
                            post = true;  //слово с постфиксом
                            break;
                        }
                    }
                }else {
                    if(post){
                        world=worldWithPostfix;
                        post=false;
                    }
                }
//--------------------------------------------------------------ПОСТФИКС
//--------------------------------------------------------------САМА ФИЛЬТРАЦИЯ
                if(world.length()!=0&& !post){
                    if(world.length()<muchOfSymbols){
                        int k=0;  //счетчик повтора слова
                        String worldOriginal = world;  //запоминаем оригинал слова
                        world=world.toLowerCase(Locale.ROOT);  //перевод в нижний регистр
                        //--------------------------------------------------------------ПОВТОР СЛОВ
                        for (String s : repeat) {
                            if (s.equals(world)) {
                                k++;
                            }
                        }
                        //--------------------------------------------------------------ПОВТОР СЛОВ
                        world=worldOriginal;  //возвращаем слово
                        //--------------------------------------------------------------ЗАМЕНА
                        if(k==1) {
                            StringBuilder newWorld = new StringBuilder();
                            for (int j = 0; j < world.length(); j++) {
                                newWorld.append("x");
                            }
                            world= newWorld.toString();
                        }
                        //--------------------------------------------------------------ЗАМЕНА
                    }
                    //--------------------------------------------------------------ПОСТФИКС
                    if(firstLengthWorldWithPostfix!=0){
                        world=world.substring(0,firstLengthWorldWithPostfix)+"-"+world.substring(firstLengthWorldWithPostfix);
                        firstLengthWorldWithPostfix=0;
                    }
                    //--------------------------------------------------------------ПОСТФИКС
                    newStroke.append(world);
                }
                //---------------------------------------------------------------САМА ФИЛЬТРАЦИЯ
                if (!post) newStroke.append(arraySymbol[p]);
                world="";
            }
        }
        System.out.println("Строка после фильрации " +newStroke);
//--------------------------------------------------------------ВТОРАЯ ФИЛЬТРАЦИЯ


    }
}
