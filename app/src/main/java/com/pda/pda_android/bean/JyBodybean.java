package com.pda.pda_android.bean;



import java.util.List;

public class JyBodybean {

    private String title;
    private List<Body> bodyList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Body> getBodyList() {
        return bodyList;
    }

    public void setBodyList(List<Body> bodyList) {
        this.bodyList = bodyList;
    }

    public static class Body{
        private String name;
        private String data;
        private String project;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getProject() {
            return project;
        }

        public void setProject(String project) {
            this.project = project;
        }
    }
}
