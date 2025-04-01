package com.example.restapi.shared.util;

import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class PaginationUtil {
    private final int currentPage;
    private final int totalPages;
    private final int pageSize;
    private final int blockSize = 10;
    private final int blockStartNumber;
    private final int blockEndNumber;
    private final boolean isFirstPageButton;
    private final boolean isPrevButton;
    private final boolean isNextButton;
    private final boolean isLastPageButton;

    public PaginationUtil(Page<?> page) {
        this.currentPage = page.getNumber() + 1;
        this.pageSize = page.getSize();
        this.totalPages = page.getTotalPages();
        this.blockStartNumber = ((currentPage - 1) / blockSize) * blockSize + 1;
        this.blockEndNumber = Math.min((blockStartNumber + blockSize - 1), totalPages);
        this.isFirstPageButton = blockStartNumber > 1;
        this.isPrevButton = blockStartNumber > 1;
        this.isNextButton = totalPages > blockEndNumber;
        this.isLastPageButton = totalPages > blockEndNumber;
    }
}
