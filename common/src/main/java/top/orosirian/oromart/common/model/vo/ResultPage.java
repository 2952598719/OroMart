package top.orosirian.oromart.common.model.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResultPage<T> {

    private Long recordsNum;

    private Integer pageSize;

    private Integer pageNum;

    private Integer currentPage;

    private List<T> records;

    public static <T> ResultVO<ResultPage<T>> success(Long recordsNum, List<T> records) {
        return ResultVO.success(ResultPage.<T>builder()
                .recordsNum(recordsNum)
                .records(records)
                .build());
    }

    public static <T> ResultVO<ResultPage<T>> success(Long recordsNum, Integer pageSize, Integer currentPage, List<T> records) {
        int pageNum = (int) Math.ceil((double) recordsNum / pageSize);
        return ResultVO.success(ResultPage.<T>builder()
                .recordsNum(recordsNum)
                .pageSize(pageSize)
                .pageNum(pageNum)
                .currentPage(currentPage)
                .records(records)
                .build());
    }



}
