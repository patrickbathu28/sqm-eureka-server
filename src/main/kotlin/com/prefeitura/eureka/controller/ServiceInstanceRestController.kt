package com.prefeitura.eureka.controller


import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable

import org.springframework.cloud.client.ServiceInstance

import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient

@RestController
class ServiceInstanceRestController {

    @Autowired
    private val discoveryClient: DiscoveryClient? = null

    @RequestMapping("/service-instances/{applicationName}")
    fun serviceInstancesByApplicationName( @PathVariable applicationName: String? ): MutableList<ServiceInstance>? {
        if (discoveryClient != null) {
            return discoveryClient.getInstances(applicationName)
        }
        return null
    }
}