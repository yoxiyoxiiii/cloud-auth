package cn.kr.authsso.domain;

public class Menu {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_menu.id
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_menu.name
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_menu.url
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_menu.group
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    private String group;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column auth_menu.user_id
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    private Integer userId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_menu.id
     *
     * @return the value of auth_menu.id
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_menu.id
     *
     * @param id the value for auth_menu.id
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_menu.name
     *
     * @return the value of auth_menu.name
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_menu.name
     *
     * @param name the value for auth_menu.name
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_menu.url
     *
     * @return the value of auth_menu.url
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_menu.url
     *
     * @param url the value for auth_menu.url
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_menu.group
     *
     * @return the value of auth_menu.group
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public String getGroup() {
        return group;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_menu.group
     *
     * @param group the value for auth_menu.group
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column auth_menu.user_id
     *
     * @return the value of auth_menu.user_id
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column auth_menu.user_id
     *
     * @param userId the value for auth_menu.user_id
     *
     * @mbg.generated Sun Jun 03 18:23:04 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}