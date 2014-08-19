/**
 * LoteRps.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.dsfnet.nfse.services;

public interface LoteRps extends java.rmi.Remote {
	public java.lang.String enviar(java.lang.String mensagemXml) throws java.rmi.RemoteException;

	public java.lang.String consultarSequencialRps(java.lang.String mensagemXml) throws java.rmi.RemoteException;

	public java.lang.String enviarSincrono(java.lang.String mensagemXml) throws java.rmi.RemoteException;

	public java.lang.String testeEnviar(java.lang.String mensagemXml) throws java.rmi.RemoteException;

	public java.lang.String consultarLote(java.lang.String mensagemXml) throws java.rmi.RemoteException;

	public java.lang.String consultarNota(java.lang.String mensagemXml) throws java.rmi.RemoteException;

	public java.lang.String cancelar(java.lang.String mensagemXml) throws java.rmi.RemoteException;

	public java.lang.String consultarNFSeRps(java.lang.String mensagemXml) throws java.rmi.RemoteException;
}
