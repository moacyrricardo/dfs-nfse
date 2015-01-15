/**
 * LoteRpsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.dsfnet.nfse.services;

public class LoteRpsServiceLocator extends org.apache.axis.client.Service implements br.com.dsfnet.nfse.services.LoteRpsService {
	private static final long serialVersionUID = 4100517574302546740L;

	public LoteRpsServiceLocator() {
	}

	public LoteRpsServiceLocator(org.apache.axis.EngineConfiguration config) {
		super(config);
	}

	public LoteRpsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
		super(wsdlLoc, sName);
	}

	// Use to get a proxy class for LoteRps
	private java.lang.String LoteRps_address = "http://issdigital.campinas.sp.gov.br/WsNFe2/LoteRps.jws";

	public java.lang.String getLoteRpsAddress() {
		return LoteRps_address;
	}

	// The WSDD service name defaults to the port name.
	private java.lang.String LoteRpsWSDDServiceName = "LoteRps";

	public java.lang.String getLoteRpsWSDDServiceName() {
		return LoteRpsWSDDServiceName;
	}

	public void setLoteRpsWSDDServiceName(java.lang.String name) {
		LoteRpsWSDDServiceName = name;
	}

	public br.com.dsfnet.nfse.services.LoteRps getLoteRps() throws javax.xml.rpc.ServiceException {
		java.net.URL endpoint;
		try {
			endpoint = new java.net.URL(LoteRps_address);
		} catch (java.net.MalformedURLException e) {
			throw new javax.xml.rpc.ServiceException(e);
		}
		return getLoteRps(endpoint);
	}

	public br.com.dsfnet.nfse.services.LoteRps getLoteRps(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
		try {
			br.com.dsfnet.nfse.services.LoteRpsSoapBindingStub _stub = new br.com.dsfnet.nfse.services.LoteRpsSoapBindingStub(portAddress, this);
			_stub.setPortName(getLoteRpsWSDDServiceName());
			return _stub;
		} catch (org.apache.axis.AxisFault e) {
			return null;
		}
	}

	public void setLoteRpsEndpointAddress(java.lang.String address) {
		LoteRps_address = address;
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
		try {
			if (br.com.dsfnet.nfse.services.LoteRps.class.isAssignableFrom(serviceEndpointInterface)) {
				br.com.dsfnet.nfse.services.LoteRpsSoapBindingStub _stub = new br.com.dsfnet.nfse.services.LoteRpsSoapBindingStub(new java.net.URL(
						LoteRps_address), this);
				_stub.setPortName(getLoteRpsWSDDServiceName());
				return _stub;
			}
		} catch (java.lang.Throwable t) {
			throw new javax.xml.rpc.ServiceException(t);
		}
		throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  "
				+ (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
	}

	/**
	 * For the given interface, get the stub implementation. If this service has
	 * no port for the given interface, then ServiceException is thrown.
	 */
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface)
			throws javax.xml.rpc.ServiceException {
		if (portName == null) {
			return getPort(serviceEndpointInterface);
		}
		java.lang.String inputPortName = portName.getLocalPart();
		if ("LoteRps".equals(inputPortName)) {
			return getLoteRps();
		} else {
			java.rmi.Remote _stub = getPort(serviceEndpointInterface);
			((org.apache.axis.client.Stub) _stub).setPortName(portName);
			return _stub;
		}
	}

	public javax.xml.namespace.QName getServiceName() {
		return new javax.xml.namespace.QName("http://nfse.campinas.sp.gov.br/WsNFe2/LoteRps.jws", "LoteRpsService");
	}

	private java.util.HashSet ports = null;

	public java.util.Iterator getPorts() {
		if (ports == null) {
			ports = new java.util.HashSet();
			ports.add(new javax.xml.namespace.QName("http://nfse.campinas.sp.gov.br/WsNFe2/LoteRps.jws", "LoteRps"));
		}
		return ports.iterator();
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

		if ("LoteRps".equals(portName)) {
			setLoteRpsEndpointAddress(address);
		} else { // Unknown Port Name
			throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
		}
	}

	/**
	 * Set the endpoint address for the specified port name.
	 */
	public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
		setEndpointAddress(portName.getLocalPart(), address);
	}

}
