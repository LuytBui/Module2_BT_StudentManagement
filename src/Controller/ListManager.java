package Controller;

import Model.ElementInList;
import Model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListManager {
    private List<ElementInList> list = new ArrayList<>();

    public ListManager() {
    }

    public void writeToFile(String path){
        try {
            File file = new File (path);
            OutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("Ghi dữ liệu thành công: "+ file.getAbsolutePath());
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void readFromFile(String path){
        try {
            File file = new File (path);
            InputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<ElementInList>) ois.readObject();
            System.out.println("Đọc dữ liệu thành công: "+ file.getAbsolutePath());
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void printList() {
        for (ElementInList element : list) {
            System.out.println(element);
        }
    }

    public void sortList() {
        Comparator<ElementInList> comparator = new Comparator<ElementInList>() {
            @Override
            public int compare(ElementInList o1, ElementInList o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
        list.sort(comparator);
    }

    public void sortList(Comparator comparator){
        list.sort(comparator);
    }

    public int size() {
        return list.size();
    }

    public void add(ElementInList element) {
        list.add(element);
    }

    public ElementInList get(int index) {
        return list.get(index);
    }

    public boolean set(int index, ElementInList element) {
        if (index < 0 || index >= list.size())
            return false;
        else {
            list.set(index, element);
            return true;
        }
    }
    public boolean remove(int index){
        if (index < 0 || index > list.size())
            return false;
        list.remove(index);
        return true;
    }

    public boolean remove(ElementInList element) {
        boolean isFound = false;
        for (ElementInList e : list) {
            if (e.equals(element))
                list.remove(e);
            isFound = true;
        }
        return isFound;
    }

    public int indexOfId(String id) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            boolean isFound = list.get(i).getId().equals(id);
            if (isFound) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int indexOfName(String name) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            boolean isFound = list.get(i).getName().equals(name);
            if (isFound) {
                index = i;
                break;
            }
        }
        return index;
    }

    public List<Integer> indexesOfNameContains(String name) {
        List<Integer> searchResult = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean isFound = list.get(i).getName().toLowerCase().contains(name);
            if (isFound) {
                searchResult.add(i);
            }
        }
        return searchResult;
    }

}
