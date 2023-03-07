package io.github.fairyspace.springbootdemo.controller;

import io.github.fairyspace.springbootdemo.service.DeviceBaseService;
import io.github.fairyspace.springbootdemo.entity.DeviceBase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xqr
 * @blog http://fairyspace.flowus.cn
 * @since 2023-03-07
 */
@RestController
@RequestMapping("/device-base")
public class DeviceBaseController {
    @Autowired
    private DeviceBaseService deviceBaseService;

    @GetMapping(value = "/{id}")
    public DeviceBase get(@PathVariable Integer id) {
        return deviceBaseService.getById(id);
    }

    @PostMapping
    public Boolean add(@RequestBody DeviceBase deviceBase) {
        return deviceBaseService.save(deviceBase);
    }

    @PutMapping
    public Boolean modify(@RequestBody DeviceBase deviceBase) {
        return deviceBaseService.updateById(deviceBase);
    }

    @DeleteMapping(value = "/{id}")
    public Boolean remove(@PathVariable Integer id) {
        return deviceBaseService.removeById(id);
    }
}
