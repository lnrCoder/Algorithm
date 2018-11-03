package com.liang.leetcode;

import com.liang.leetcode.Interface.L341.NestedInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName L341
 * @description flatten-nested-list-iterator
 * @Author LiaNg
 * @Date 2018/11/3
 */
public class NestedIterator implements Iterator<Integer>  {

    List<NestedInteger> list ;

    public NestedIterator(List<NestedInteger> nestedList) {

        //TODO 思路没理清楚，待做

        list = nestedList;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }

}
