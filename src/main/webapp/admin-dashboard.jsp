<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="https://cdn.tailwindcss.com"></script>
	<title>Admin Dashboard | Evently</title>
</head>
<body class="bg-slate-100 text-gray-800">
<div class="min-h-screen flex">
	<aside class="w-56 bg-indigo-200 border-r border-gray-200 p-4 sm:p-5">
		<h1 class="text-xl font-bold text-indigo-600">Evently</h1>
		<p class="text-xs text-gray-500 mt-1">Welcome, ${user.username}</p>

		<nav class="mt-8 space-y-1 text-sm">
			<a href="#" class="block px-3 py-2 rounded-md bg-indigo-50 text-indigo-700 font-medium">Dashboard</a>
			<a href="#" class="block px-3 py-2 rounded-md hover:bg-gray-100">Events</a>
			<a href="#" class="block px-3 py-2 rounded-md hover:bg-gray-100">Requests</a>
			<a href="#" class="block px-3 py-2 rounded-md hover:bg-gray-100">Members</a>
			<a href="#" class="block px-3 py-2 rounded-md hover:bg-gray-100">Reports</a>
		</nav>

		<div class="mt-8 pt-6 border-t border-gray-200">
			<a href="index.jsp" class="text-sm text-indigo-600 hover:text-indigo-700">Logout</a>
		</div>
	</aside>

	<main class="flex-1 p-5 sm:p-8">
		<div class=" rounded-xl border border-gray-200 p-5 sm:p-6">
			<div class="flex flex-col lg:flex-row lg:items-center lg:justify-between gap-4">
				<div>
					<h2 class="text-2xl font-semibold">Dashboard</h2>
					<p class="text-sm text-gray-500 mt-1">Manage events and monitor requests.</p>
				</div>
				<div class="flex flex-col sm:flex-row gap-3 w-full lg:w-auto">
					<input
						type="text"
						name="search"
						placeholder="Search by event, member, or keyword"
						class="w-full sm:w-80 px-4 py-2.5 bg-gray-50 border border-gray-300 rounded-lg outline-none focus:ring-2 focus:ring-indigo-500"
					>
					<select
						name="location"
						class="px-4 py-2.5 bg-gray-50 border border-gray-300 rounded-lg outline-none focus:ring-2 focus:ring-indigo-500"
					>
						<option value="">All Locations</option>
						<option value="Itahari">Itahari</option>
						<option value="Biratnagar">Biratnagar</option>
						<option value="Damak">Damak</option>
						<option value="Dharan">Dharan</option>
						<option value="Inaruwa">Inaruwa</option>
					</select>
				</div>
			</div>

			<div class="grid grid-cols-1 md:grid-cols-3 gap-4 mt-6">
				<div class="border border-gray-200 rounded-lg p-4">
					<p class="text-sm text-gray-500">Total Events</p>
					<p class="text-2xl font-semibold mt-1">12</p>
				</div>
				<div class="border border-gray-200 rounded-lg p-4">
					<p class="text-sm text-gray-500">Pending Requests</p>
					<p class="text-2xl font-semibold mt-1">7</p>
				</div>
				<div class="border border-gray-200 rounded-lg p-4">
					<p class="text-sm text-gray-500">Active Members</p>
					<p class="text-2xl font-semibold mt-1">214</p>
				</div>
			</div>

			<div class="mt-6 border border-gray-200 rounded-lg overflow-x-auto">
				<table class="w-full text-sm">
					<thead class="bg-gray-50 text-gray-700">
					<tr>
						<th class="text-left px-4 py-3 font-medium">Event</th>
						<th class="text-left px-4 py-3 font-medium">Location</th>
						<th class="text-left px-4 py-3 font-medium">Date</th>
						<th class="text-left px-4 py-3 font-medium">Status</th>
					</tr>
					</thead>
					<tbody class="divide-y divide-gray-200">
					<tr>
						<td class="px-4 py-3">Campus Tech Meetup</td>
						<td class="px-4 py-3">Biratnagar</td>
						<td class="px-4 py-3">12 Apr</td>
						<td class="px-4 py-3"><span class="text-amber-700 bg-amber-100 px-2 py-1 rounded">Pending</span></td>
					</tr>
					<tr>
						<td class="px-4 py-3">Community Service Drive</td>
						<td class="px-4 py-3">Itahari</td>
						<td class="px-4 py-3">18 Apr</td>
						<td class="px-4 py-3"><span class="text-emerald-700 bg-emerald-100 px-2 py-1 rounded">Approved</span></td>
					</tr>
					<tr>
						<td class="px-4 py-3">Sports and Wellness Day</td>
						<td class="px-4 py-3">Damak</td>
						<td class="px-4 py-3">25 Apr</td>
						<td class="px-4 py-3"><span class="text-sky-700 bg-sky-100 px-2 py-1 rounded">Open</span></td>
					</tr>
					</tbody>
				</table>
			</div>

			<div class="mt-6">
				<h3 class="text-base font-semibold">Future Features (Can Be Implemented Next)</h3>
				<ul class="mt-3 text-sm text-gray-600 list-disc list-inside space-y-1">
					<li>Export filtered events and requests to CSV.</li>
					<li>Bulk approve or reject member join requests.</li>
					<li>Calendar view for monthly event planning.</li>
					<li>Email or SMS notifications on request updates.</li>
					<li>Role-based access for super admin and event coordinators.</li>
				</ul>
			</div>
		</div>
	</main>
</div>
</body>
</html>
