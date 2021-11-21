package com.gmail.alexey375890.dto;

public class WmProjectsDTO {

    private Long id;

    private String title;

    private Long authorId;

    private Long clientCompanyId;

    public WmProjectsDTO(Long id, String title, Long authorId, Long clientCompanyId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.clientCompanyId = clientCompanyId;
    }

    public WmProjectsDTO() {
    }

    public Long getId() {
        return id;
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

    public Long getClientCompanyId() {
        return clientCompanyId;
    }

    public void setClientCompanyId(Long clientCompanyId) {
        this.clientCompanyId = clientCompanyId;
    }

    @Override
    public String toString() {
        return "WmProjectsDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                ", clientCompanyId=" + clientCompanyId +
                '}';
    }
}
