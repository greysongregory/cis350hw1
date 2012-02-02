package edu.upenn.cis350.gpx;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;


public class GPXcalculatorTest {
	
	GPXtrkpt nulls, zeros, ones, twos, threes, tooBigLat, tooSmallLat, tooBigLon, tooSmallLon;
	ArrayList<GPXtrkpt> simpleDistancePts, emptyTrkPts, withNullTrkPt, singleTrkPt, tooBigLatPt, tooSmallLatPt, tooBigLonPt, tooSmallLonPt;
	GPXtrkseg simpleDistSeg, nullTrkSeg, emptyTrkSeg, withNullTrkSeg, singlePtTrkSeg, tooBigLatSeg, tooSmallLatSeg, tooBigLonSeg, tooSmallLonSeg;
	ArrayList<GPXtrkseg> trkWithSimpleDistance, emptyTrkSegs, trkWithNullSeg, trkWithEmptySeg, trkWithOnePtSeg, trkWithNullPtSeg, trkWithBigLat, trkWithSmallLat, trkWithBigLon, trkWithSmallLon;
	GPXtrk simpleDistTrk, emptyTrk, nullSegTrk, emptySegTrk, singlePtTrk, nullPtTrk, bigLatTrk, smallLatTrk, bigLonTrk, smallLonTrk, testTrk;
	
	protected void setUp(){
		nulls = null;
		zeros = new GPXtrkpt(0, 0, null);
		ones = new GPXtrkpt(1, 1, null);
		twos = new GPXtrkpt(2, 2, null);
		threes = new GPXtrkpt(3, 4, null);
		tooBigLat = new GPXtrkpt(91, 0, null);
		tooSmallLat = new GPXtrkpt(-91, 0, null);
		tooBigLon = new GPXtrkpt(0, 181, null);
		tooSmallLon = new GPXtrkpt(0, -181, null);
		
		simpleDistancePts = new ArrayList<GPXtrkpt>();
		simpleDistancePts.add(zeros);
		simpleDistancePts.add(threes);
		emptyTrkPts = new ArrayList<GPXtrkpt>();
		withNullTrkPt =  new ArrayList<GPXtrkpt>();
		singleTrkPt.add(ones);
		withNullTrkPt.add(nulls);
		singleTrkPt.add(ones);
		singleTrkPt =  new ArrayList<GPXtrkpt>();
		singleTrkPt.add(ones);
		tooBigLatPt = new ArrayList<GPXtrkpt>();
		tooBigLatPt.add(tooBigLat);
		tooBigLatPt.add(tooBigLat);
		tooSmallLatPt = new ArrayList<GPXtrkpt>();
		tooSmallLatPt.add(tooSmallLat);
		tooSmallLatPt.add(tooSmallLat);
		tooBigLonPt = new ArrayList<GPXtrkpt>();
		tooBigLonPt.add(tooBigLon);
		tooBigLonPt.add(tooBigLon);
		tooSmallLonPt = new ArrayList<GPXtrkpt>();
		tooSmallLonPt.add(tooSmallLon);
		tooSmallLonPt.add(tooSmallLon);
		
		simpleDistSeg = new GPXtrkseg(simpleDistancePts);
		nullTrkSeg = new GPXtrkseg(null);
		emptyTrkSeg = new GPXtrkseg(emptyTrkPts);
		withNullTrkSeg = new GPXtrkseg(withNullTrkPt);
		singlePtTrkSeg = new GPXtrkseg(singleTrkPt);
		tooBigLatSeg = new GPXtrkseg(tooBigLatPt);
		tooSmallLatSeg = new GPXtrkseg(tooSmallLatPt);
		tooBigLonSeg = new GPXtrkseg(tooBigLonPt);
		tooSmallLonSeg = new GPXtrkseg(tooSmallLonPt);
		
		//emptyTrkSegs, trkWithNullSeg, trkWithEmptySeg, trkWithOnePtSeg, trkWithNullPtSeg, trkWithBigLat, trkWithSmallLat, trkWithBigLon, trkWithSmallLon;
		trkWithSimpleDistance = new ArrayList<GPXtrkseg>();
		trkWithSimpleDistance.add(simpleDistSeg);
		emptyTrkSegs = new ArrayList<GPXtrkseg>();
		trkWithNullSeg = new ArrayList<GPXtrkseg>();
		trkWithNullSeg.add(nullTrkSeg);
		trkWithEmptySeg = new ArrayList<GPXtrkseg>();
		trkWithEmptySeg.add(emptyTrkSeg);
		trkWithOnePtSeg = new ArrayList<GPXtrkseg>();
		trkWithOnePtSeg.add(singlePtTrkSeg);
		trkWithNullPtSeg = new ArrayList<GPXtrkseg>();
		trkWithNullPtSeg.add(withNullTrkSeg);
		trkWithBigLat = new ArrayList<GPXtrkseg>();
		trkWithBigLat.add(tooBigLatSeg);
		trkWithSmallLat = new ArrayList<GPXtrkseg>();
		trkWithSmallLat.add(tooSmallLatSeg);
		trkWithBigLon = new ArrayList<GPXtrkseg>();
		trkWithBigLon.add(tooBigLonSeg);
		trkWithSmallLon = new ArrayList<GPXtrkseg>();
		trkWithSmallLon.add(tooSmallLonSeg);
		
		//emptyTrk, nullSegTrk, emptySegTrk, singlePtTrk, nullPtTrk, bigLatTrk, smallLatTrk, bigLonTrk, smallLonTrk;
		simpleDistTrk = new GPXtrk("simple", trkWithSimpleDistance);
		emptyTrk = new GPXtrk("empty", emptyTrkSegs);
		nullSegTrk = new GPXtrk("null", trkWithNullSeg);
		emptySegTrk = new GPXtrk("emptySeg", trkWithEmptySeg);
		singlePtTrk = new  GPXtrk("onePtSeg", trkWithOnePtSeg);
		nullPtTrk = new GPXtrk("pullPtSeg", trkWithNullPtSeg);
		bigLatTrk = new GPXtrk("bigLat", trkWithBigLat);
		smallLatTrk = new GPXtrk("smallLat", trkWithSmallLat);
		bigLonTrk = new GPXtrk("bigLon", trkWithBigLon);
		smallLonTrk = new GPXtrk("smallLon", trkWithSmallLon);
	}
	
	public GPXtrk makeTrk(GPXtrkseg first, GPXtrkseg second,  GPXtrkseg third){
		ArrayList<GPXtrkseg> temptrkseg = new ArrayList<GPXtrkseg>();
		temptrkseg.add(first);
		temptrkseg.add(second);
		temptrkseg.add(third);
		return new GPXtrk("test", temptrkseg);
	}
	
	@Test
	public void testGPXtrkNull() {
		assertEquals(GPXcalculator.calculateDistanceTraveled(null), -1, 0);
	}
	
	@Test
	public void testGPXtrkEmpty(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(emptyTrk), -1, 0);
	}
	
	@Test
	public void testGPXtrkSegIsNull(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(nullSegTrk), 0, 0);
		//make another test with multiple segments
		GPXtrk testTrk = makeTrk(simpleDistSeg, nullTrkSeg, simpleDistSeg);
		assertEquals(GPXcalculator.calculateDistanceTraveled(testTrk), 10, 0);
	}
	
	@Test
	public void testGPXtrkWithEmptySeg(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(emptySegTrk), 0, 0);
		//another test with multiple segments
		GPXtrk testTrk = makeTrk(simpleDistSeg, emptyTrkSeg, simpleDistSeg);
		assertEquals(GPXcalculator.calculateDistanceTraveled(testTrk), 10, 0);
	}
	
	@Test
	public void testGPXtrkWithSinglePtSeg(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(singlePtTrk), 0, 0);
		//another test with other segments added
		GPXtrk testTrk = makeTrk(simpleDistSeg, singlePtTrkSeg, simpleDistSeg);
		assertEquals(GPXcalculator.calculateDistanceTraveled(testTrk), 10, 0);
	}
	
	@Test
	public void testGPXtrkWithNullPtSeg(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(nullPtTrk), 0, 0);
		//another test with other segments added
		GPXtrk testTrk = makeTrk(simpleDistSeg, withNullTrkSeg, simpleDistSeg);
		assertEquals(GPXcalculator.calculateDistanceTraveled(testTrk), 10, 0);
	}
	
	@Test
	public void testGPXtrkBigLat(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(bigLatTrk), 0, 0);
		//another test with other segments added
		GPXtrk testTrk = makeTrk(simpleDistSeg, tooBigLatSeg, simpleDistSeg);
		assertEquals(GPXcalculator.calculateDistanceTraveled(testTrk), 10, 0);
	}
	
	@Test
	public void testGPXtrkSmallLat(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(smallLatTrk), 0, 0);
		//another test with other segments added
		GPXtrk testTrk = makeTrk(simpleDistSeg, tooSmallLatSeg, simpleDistSeg);
		assertEquals(GPXcalculator.calculateDistanceTraveled(testTrk), 10, 0);
	}
	
	@Test
	public void testGPXtrkBigLon(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(bigLonTrk), 0, 0);
		GPXtrk testTrk = makeTrk(simpleDistSeg, tooBigLonSeg, simpleDistSeg);
		assertEquals(GPXcalculator.calculateDistanceTraveled(testTrk), 10, 0);
	}
	
	@Test
	public void testGPXtrkSmallLon(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(smallLonTrk), 0, 0);
		GPXtrk testTrk = makeTrk(simpleDistSeg, tooSmallLonSeg, simpleDistSeg);
		assertEquals(GPXcalculator.calculateDistanceTraveled(testTrk), 10, 0);
	}
	
	@Test
	public void testGPXtrkSimpleDistance(){
		assertEquals(GPXcalculator.calculateDistanceTraveled(simpleDistTrk), 5, 0);
	}
}
