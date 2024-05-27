package com.example.pojo;

import java.util.List;

/**
 * 分页封装对象
 */
public class PageBean<T> {
    private int totalCount; // 总记录数
    private int totalPage; // 总页码
    private int currentPage; // 当前页码
    private int rows; // 每页显示的记录数
    private List<T> list; // 每页显示的数据

    public PageBean() {
    }

    public PageBean(int totalCount, int totalPage, int currentPage, int rows, List<T> list) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.rows = rows;
        this.list = list;
    }

    /**
     * 获取
     *
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置
     *
     * @param totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 获取
     *
     * @return totalPage
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * 设置
     *
     * @param totalPage
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 获取
     *
     * @return currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * 设置
     *
     * @param currentPage
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 获取
     *
     * @return rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * 设置
     *
     * @param rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * 获取
     *
     * @return list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置
     *
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    public String toString() {
        return "PageBean{totalCount = " + totalCount + ", totalPage = " + totalPage + ", currentPage = " + currentPage + ", rows = " + rows + ", list = " + list + "}";
    }
}
