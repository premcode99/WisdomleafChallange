package com.example.wisdomleafchallange.PresentationModel.Picsum;

public class PicSumDataModel {
        private String id;
        private String author;
        private Integer width;
        private Integer height;
        private String url;
        private String download_url;

        public PicSumDataModel() {
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public Integer getWidth() {
                return width;
        }

        public void setWidth(Integer width) {
                this.width = width;
        }

        public Integer getHeight() {
                return height;
        }

        public void setHeight(Integer height) {
                this.height = height;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public String getDownload_url() {
                return download_url;
        }

        public void setDownload_url(String download_url) {
                this.download_url = download_url;
        }
}
