package perparation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisposeCSV {
    public static List<List<String>> removeCol(List<List<String>> list, int col){
        List<List<String>> result = new ArrayList<>();
        for(int k = 0; k < list.size(); k++){
            List<String> new_stringList = new ArrayList<>();
            List<String> stringList = list.get(k);
            for(int i = 0 ; i < stringList.size(); i++){
                if(i != col){
                    new_stringList.add(stringList.get(i));
                }
            }
            result.add(new_stringList);
        }
        return result;
    }
    public static List<List<String>> removeCol(List<List<String>> list, int col, int col1){
        List<List<String>> result = new ArrayList<>();
        for(int k = 0; k < list.size(); k++){
            List<String> new_stringList = new ArrayList<>();
            List<String> stringList = list.get(k);
            for(int i = 0 ; i < stringList.size(); i++){
                if(i != col && i != col1){
                    new_stringList.add(stringList.get(i));
                }
            }
            result.add(new_stringList);
        }
        return result;
    }
    public static List<List<String>> removeCol(List<List<String>> list, int col, int col1, int col2){
        List<List<String>> result = new ArrayList<>();
        for(int k = 0; k < list.size(); k++){
            List<String> new_stringList = new ArrayList<>();
            List<String> stringList = list.get(k);
            for(int i = 0 ; i < stringList.size(); i++){
                if(i != col && i != col1 && i != col2){
                    new_stringList.add(stringList.get(i));
                }
            }
            result.add(new_stringList);
        }
        return result;
    }
    public static List<List<String>> removeCol(List<List<String>> list, int col, int col1, int col2, int col3){
        List<List<String>> result = new ArrayList<>();
        for(int k = 0; k < list.size(); k++){
            List<String> new_stringList = new ArrayList<>();
            List<String> stringList = list.get(k);
            for(int i = 0 ; i < stringList.size(); i++){
                if(i != col && i != col1 && i != col2 && i !=col3){
                    new_stringList.add(stringList.get(i));
                }
            }
            result.add(new_stringList);
        }
        return result;
    }
    public static List<List<String>> removeCol(List<List<String>> list, int col, int col1, int col2, int col3,
                                               int col4, int col5, int col6, int col7){
        List<List<String>> result = new ArrayList<>();
        for(int k = 0; k < list.size(); k++){
            List<String> new_stringList = new ArrayList<>();
            List<String> stringList = list.get(k);
            for(int i = 0 ; i < stringList.size(); i++){
                if(i != col && i != col1 && i != col2 && i !=col3 &&
                        i !=col4 && i !=col5 && i !=col6 && i !=col7 ){
                    new_stringList.add(stringList.get(i));
                }
            }
            result.add(new_stringList);
        }
        return result;
    }


    public static List<List<String>> removeCol(List<List<String>> list, List<Integer> col){
        List<List<String>> result = new ArrayList<>();
        for(int k = 0; k < list.size(); k++){
            List<String> new_stringList = new ArrayList<>();
            List<String> stringList = list.get(k);
            for(int i = 0 ; i < stringList.size(); i++){
                if(!col.contains(i)){
                    new_stringList.add(stringList.get(i));
                }
            }
            result.add(new_stringList);
        }
        return result;
    }

    public static List<Integer> setCol(int begin, int end){
        List<Integer> col = new ArrayList<>();
        for(int i = begin; i <= end; i++){
            col.add(i);
        }
        return col;
    }

    public static List<List<String>> getSubList (List<List<String>>list,int begin, int row,boolean hasTitle){
        if(!hasTitle)
            return list.subList(begin, begin+row);
        else {
            List<List<String>> listList = list.subList(begin + 1, begin + row + 1);
            listList.add(0, list.get(0));
            return listList;
        }
    }

    public static  List<List<String>> readCSV(String path) throws IOException {
        File csv = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(csv));
        String lineDta = "";
        List<List<String>> List = new ArrayList<>();

        while ((lineDta = br.readLine())!= null){
            List<String> stringListlist = Arrays.asList(lineDta.split(","));
            List.add(stringListlist);
        }
        return List;
    }

    public static void writeCSV(List<List<String>> result, String path) throws IOException {
        System.out.println("----------------------------------");
        System.out.println("写文件：");
        File csv2 = new File(path);//CSV文件
        BufferedWriter bw = new BufferedWriter(new FileWriter(csv2,true));
        for(int i = 0; i < result.size(); i++){
            String s0 = String.join(",",result.get(i));
            bw.write(s0);
            bw.newLine();
        }
        bw.close();
        System.out.println("写文件结束");
    }


    public static void main(String[] args) throws IOException {
        //读文件
        List<List<String>> lists = readCSV("newdata/flights-int 500K 17.csv");


        //只保留93w条数据
        List<List<String>> new_list = getSubList(lists,0,50000, true);


        //删除列
        //        List<Integer> col = setCol(0,14);
//        List<List<String>> result = removeCol(lists,1,2,3,8,10,12,16,18);

//        int len = result.get(0).size();
//        List<String> new_title = new ArrayList<>();
//        for(int i = 0; i < len; i++){
//            new_title.add(String.valueOf(i));
//        }
//        result.remove(0);
//        result.add(0, new_title);

        //写文件
        writeCSV(new_list, "newdata/flights-int 50K 17.csv.csv");
    }




}
