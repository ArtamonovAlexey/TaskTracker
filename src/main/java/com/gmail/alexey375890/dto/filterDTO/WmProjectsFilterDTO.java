package com.gmail.alexey375890.dto.filterDTO;

public class WmProjectsFilterDTO {

    private String title;

    private Long authorId;

    private Long companyId;

    private Long statusId;

    public WmProjectsFilterDTO(String title, Long authorId, Long companyId, Long statusId) {
        this.title = title;
        this.authorId = authorId;
        this.companyId = companyId;
        this.statusId = statusId;
    }

    public WmProjectsFilterDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
