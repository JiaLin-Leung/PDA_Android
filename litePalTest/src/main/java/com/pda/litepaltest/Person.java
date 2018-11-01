package com.pda.litepaltest;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * 梁佳霖创建于：2018/11/1 09:14
 * 功能：
 */
public class Person extends DataSupport {

    private String userName = "哈哈";
    private String password = "11111";
    private List<PersonBean> data;

    private class PersonBean {
        private String title;
        private List<PersonBeanlistBean> datal;

        @Override
        public String toString() {
            return "PersonBean{" +
                    "title='" + title + '\'' +
                    ", datal=" + datal +
                    '}';
        }


        private class PersonBeanlistBean {
            private String username;
            private String passwww;

            @Override
            public String toString() {
                return "PersonBeanlistBean{" +
                        "username='" + username + '\'' +
                        ", passwww='" + passwww + '\'' +
                        '}';
            }

        }
    }
}
