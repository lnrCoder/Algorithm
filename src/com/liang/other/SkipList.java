package com.liang.other;

/**
 * @ClassName SkipList
 * @description 跳表
 * @Author LiaNg
 * @Date 2019-05-24
 */

class Node {

    int value = -1;
    //跨越层数
    int level;
    //指向下一个节点
    Node[] next;

    public Node(int value, int level) {
        this.value = value;
        this.level = level;
        this.next = new Node[level];
    }
}

public class SkipList {

    // 允许的最大层数
    int maxLevel = 16;
    // 头结点
    Node head = new Node(-1, 16);
    // 当前节点数
    int size = 0;
    // 当前层数
    int levelCount = 1;

    public Node find(int value){
        Node temp = head;

        for (int i = levelCount - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].value < value) {
                temp = temp.next[i];
            }
        }

        if (temp.next[0] != null && temp.next[0].value == value) {
            System.out.println(value + "查找成功");
            return temp.next[0];
        }else {
            return null;
        }
    }

    public void insert(int value) {
        int level = getLevel();
        Node newNode = new Node(value, level);
        Node[] update = new Node[level];

        Node temp = head;

        for (int i = level - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].value < value) {
                temp = temp.next[i];
            }
            update[i] = temp;
        }

        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }

        if (level > levelCount) {
            levelCount = level;
        }

        size++;
        System.out.println(value + "插入成功");
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node temp = head;

        for (int i = levelCount - 1; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].value < value) {
                temp = temp.next[i];
            }
            update[i] = temp;
        }

        if (temp.next != null && temp.next[0].value == value) {
            size--;
            System.out.println(value + "删除成功");
            for (int i = levelCount - 1; i >= 0; i--) {
                if (update[i].next[i] != null && update[i].next[i].value == value) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }

    }

    //打印所有节点
    public void printAllNode() {
        Node temp = head;
        while (temp.next[0] != null) {
            System.out.println(temp.next[0].value + "  ");
            temp = temp.next[0];
        }
    }

    // 随机节点跨度
    private int getLevel() {
        int level = 1;
        while (true) {
            int t = (int)(Math.random() * 100);
            if (t % 2 == 0) {
                level++;
            } else {
                break;
            }
        }
        System.out.println("当前的level = " + level);
        return level;
    }

    public static void main(String[] args) {
        SkipList skList = new SkipList();
        for (int i = 0; i < 6; i++) {
            skList.insert(i);
        }
        skList.printAllNode();
        skList.delete(4);
        skList.printAllNode();
        System.out.println(skList.find(3).value);
        System.out.println(skList.size + " " + skList.levelCount);

    }
}
