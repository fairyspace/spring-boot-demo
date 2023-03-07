package io.github.fairyspace.springbootdemo.entity;

    import com.baomidou.mybatisplus.extension.activerecord.Model;
    import io.github.fairyspace.springbootdemo.beans.common.BaseEntity;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
        import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author xqr
* @blog http://fairyspace.flowus.cn
* @since 2023-03-07
*/
    @Data
        @EqualsAndHashCode(callSuper = true)
        @Accessors(chain = true)
    public class DeviceBase extends BaseEntity<DeviceBase> {

    private static final long serialVersionUID = 2L;

    private String hostname;

    private String password;

    private String username;

    private String firmwareVersion;

    private String hardwareId;

    private String manufacturer;

    private String model;

    private String serialNumber;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}