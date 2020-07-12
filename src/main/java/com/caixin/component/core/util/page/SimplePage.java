package com.caixin.component.core.util.page;

/**
 * 简单分页类
 */
public class SimplePage implements Paginable {


    public static final int DEF_COUNT = 20;

    /**
     * 检查页码 checkPageNo
     *
     * @param pageNo 页号
     * @return 页号
     */
    public static int cpn(Integer pageNo) {
        return (pageNo == null || pageNo < 1) ? 1 : pageNo;
    }

    /**
     * 检查每页条数
     *
     * @param pageSize 条数
     * @return 矫正值
     * @author yjy
     * Created on 2017年12月5日 下午2:39:23
     */
    public static int cps(Integer pageSize) {
        return (pageSize == null || pageSize < 1) ? DEF_COUNT : pageSize;
    }

    /**
     * 根据页号和条数计算起始下标
     *
     * @param pageNo   页号
     * @param pageSize 条数
     * @return 起始下标 return (pageNo - 1) * pageSize
     * @author yjy
     * Created on 2017年12月6日 上午9:36:17
     */
    public static int getStart(Integer pageNo, Integer pageSize) {
        return (cpn(pageNo) - 1) * cps(pageSize);
    }

    public SimplePage() {
    }

    /**
     * 构造器
     *
     * @param pageNo     页码
     * @param pageSize   每页几条数据
     * @param totalCount 总共几条数据
     */
    public SimplePage(int pageNo, int pageSize, int totalCount) {
        setTotalCount(totalCount);
        setPageSize(pageSize);
        setPageNo(pageNo);
        adjustPageNo();
    }

    /**
     * 调整页码，使不超过最大页数
     */
    public void adjustPageNo() {
        if (pageNo == 1) {
            return;
        }
        int tp = getTotalPage();
        if (pageNo > tp) {
            pageNo = tp;
        }
    }

    /**
     * 获得页码
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 每页几条数据
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 总共几条数据
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 总共几页
     */
    public int getTotalPage() {
        int totalPage = totalCount / pageSize;
        if (totalPage == 0 || totalCount % pageSize != 0) {
            totalPage++;
        }
        return totalPage;
    }

    /**
     * 是否第一页
     */
    public boolean isFirstPage() {
        return pageNo <= 1;
    }

    /**
     * 是否最后一页
     */
    public boolean isLastPage() {
        return pageNo >= getTotalPage();
    }

    /**
     * 下一页页码
     */
    public int getNextPage() {
        if (isLastPage()) {
            return pageNo;
        } else {
            return pageNo + 1;
        }
    }

    /**
     * 上一页页码
     */
    public int getPrePage() {
        if (isFirstPage()) {
            return pageNo;
        } else {
            return pageNo - 1;
        }
    }

    protected int totalCount = 0;
    protected int pageSize = 20;
    protected int pageNo = 1;

    /**
     * @param totalCount 总记录数
     */
    public void setTotalCount(int totalCount) {
        if (totalCount < 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }
    }

    /**
     * @param pageSize 条数
     */
    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = DEF_COUNT;
        } else {
            this.pageSize = pageSize;
        }
    }

    /**
     * @param pageNo 页号
     */
    public void setPageNo(int pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else {
            this.pageNo = pageNo;
        }
    }
}
